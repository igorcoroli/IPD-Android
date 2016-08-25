package com.ppgee.ufam.ipd_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap inputImage; // make bitmap from image resource

    static {
        System.loadLibrary("opencv_java3");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputImage = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) this.findViewById(R.id.imageView);
//        imageView.setImageBitmap(inputImage);

        Mat rgba = new Mat();
        Utils.bitmapToMat(inputImage, rgba);
        Imgproc.cvtColor(rgba, rgba, Imgproc.COLOR_RGBA2GRAY);
        Utils.matToBitmap(rgba, inputImage);
        imageView.setImageBitmap(inputImage);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
