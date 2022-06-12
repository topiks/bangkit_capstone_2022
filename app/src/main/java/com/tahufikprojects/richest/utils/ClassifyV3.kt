package com.tahufikprojects.richest.utils

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import com.tahufikprojects.richest.ml.RichestV2


class ClassifyV3(context: Context) {
    lateinit var context: Context
    private val imageSize = 224
    var hasil_deteksi: String? = null

    init
    {
        this.context = context
    }

//    class ClassifyV3(context: Context)
//    {
//        this.context = context
//    }

    fun classify(image: Bitmap) {
        try {
            val model: RichestV2 = RichestV2.newInstance(this.context)

            // Creates inputs for reference.
            val inputFeature0 =
                TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
            val byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3)
            byteBuffer.order(ByteOrder.nativeOrder())
            val intValues = IntArray(imageSize * imageSize)
            image.getPixels(intValues, 0, image.width, 0, 0, image.width, image.width)
            var pixel = 0
            for (i in 0 until imageSize) {
                for (j in 0 until imageSize) {
                    val `val` = intValues[pixel++]
                    byteBuffer.putFloat((`val` shr 16 and 0xFF) * (1f / 255))
                    byteBuffer.putFloat((`val` shr 8 and 0xFF) * (1f / 255))
                    byteBuffer.putFloat((`val` and 0xFF) * (1f / 255))
                }
            }
            inputFeature0.loadBuffer(byteBuffer)

            // Runs model inference and gets result.
            val outputs: RichestV2.Outputs = model.process(inputFeature0)
            val outputFeature0: TensorBuffer = outputs.getOutputFeature0AsTensorBuffer()
            val confidences = outputFeature0.floatArray
            var maxPos = 0
            var maxConfidences = 0f
            for (i in confidences.indices) {
                if (confidences[i] > maxConfidences) {
                    maxConfidences = confidences[i]
                    maxPos = i
                }
            }
            val classes = arrayOf(
                "Bacterial Leaf Blight",
                "Bacterial Leaf Streak",
                "Bacterial Panicle Blight",
                "Blast",
                "Brown Spot",
                "Dead Heart",
                "Downy Mildew",
                "Hispa",
                "Normal",
                "Tungro"
            )
            hasil_deteksi = classes[maxPos]

            // Releases model resources if no longer used.
            model.close()
        } catch (e: IOException) {
            // TODO Handle the exception
        }
    }
}