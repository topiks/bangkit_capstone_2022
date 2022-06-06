package com.tahufikprojects.richest.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.tahufikprojects.richest.ml.Richest;
import com.tahufikprojects.richest.ml.RichestV2;
import com.tahufikprojects.richest.scan.CaptureActivity;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClassifiyV2 {

    private Context context;
    private int imageSize = 224;
    public String hasil_deteksi;

    public ClassifiyV2(Context context)
    {
        this.context = context;
    }

    public void testting()
    {
        Log.d("test", "mashokbro");
    }
    
    public void classify(Bitmap image)
    {
        try {
            RichestV2 model = RichestV2.newInstance(this.context);

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getWidth());
            int pixel = 0;

            for(int i = 0; i < imageSize; i++)
            {
                for(int j = 0; j < imageSize; j++)
                {
                    int val = intValues[pixel++];
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255));
                    byteBuffer.putFloat(((val) & 0xFF) * (1.f / 255));

                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            RichestV2.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            int maxPos = 0;
            float maxConfidences = 0;

            for(int i = 0; i < confidences.length; i++)
            {
                if(confidences[i] > maxConfidences)
                {
                    maxConfidences = confidences[i];
                    maxPos = i;
                }
            }

            String[] classes = {"Bacterial Leaf Blight", "Bacterial Leaf Streak", "Bacterial Panicle Blight", "Blast", "Brown Spot",
            "Dead Heart", "Downy Mildew", "Hispa", "Normal", "Tungro"};

//            Log.d("hasil", classes[maxPos]);
            hasil_deteksi = classes[maxPos];

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }
    }
}
