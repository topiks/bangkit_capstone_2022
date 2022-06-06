package com.tahufikprojects.richest.scan

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_capture.*
import java.util.*
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.ContentValues
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.content.FileProvider
import com.tahufikprojects.richest.R
import com.tahufikprojects.richest.main.PilihSawahJavaActivity
import com.tahufikprojects.richest.ml.Richest
import com.tahufikprojects.richest.utils.Classifier
import com.tahufikprojects.richest.utils.ClassifiyV2
import kotlinx.android.synthetic.main.activity_pilih_sawah_java.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.io.IOException

private const val REQUEST_CODE = 42
private lateinit var photoFile: File
var FILE_NAME:String = "photo.jpg"


class CaptureActivity : AppCompatActivity() {

    private val mInputSize = 224
//    private val mModelPath = "mobilenet_v1_1.0_224_quant.tflite"
//    private val mLabelPath = "labels_mobilenet_quant_v1_224.txt"

    private val mModelPath = "converted_model.tflite"
    private val mLabelPath = "label.txt"

    private lateinit var classifier: Classifier
    private lateinit var myClass: ClassifiyV2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture)

        initClassifier()

        btn_camera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = getPhotoFile(FILE_NAME)

            val fileProvider = FileProvider.getUriForFile(this, "com.tahufikprojects.richest.fileprovider", photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)

            if(takePictureIntent.resolveActivity(this.packageManager) != null)
            {
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            }

            else
                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_LONG).show()
        }

        btn_deteksi.setVisibility(View.INVISIBLE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            var takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
            image_preview.rotation = 90F
//            takenImage = Bitmap.createScaledBitmap(takenImage, mInputSize, mInputSize, false)
            image_preview.setImageBitmap(takenImage)

//            image_preview.setOnClickListener {
//                val result = classifier.recognizeImage(takenImage)
//                runOnUiThread { Toast.makeText(this, result.get(0).title, Toast.LENGTH_SHORT).show() }
//            }

            btn_deteksi.setVisibility(View.VISIBLE)
            btn_deteksi.setOnClickListener {
                takenImage = Bitmap.createScaledBitmap(takenImage, mInputSize, mInputSize, false)
                myClass.classify(takenImage)
                val result = myClass.hasil_deteksi
                var detectAct = Intent(this@CaptureActivity, HasilActivity::class.java)
                detectAct.putExtra("hasil_deteksi", result)
                startActivity(detectAct)

            }
        }
    }

    private fun getPhotoFile(fileName: String): File
    {
        var storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)

    }

    private fun initClassifier() {
        classifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)
        myClass = ClassifiyV2(this)
    }

}