package com.example.trevrawr.morsetranslator;

/**
* Created by emreerhan on 2015-02-13.
*/
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import EncoderDecoder.MorsePacket;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {
    private Camera mCamera;
    private SurfaceHolder mHolder;
    private byte[] pixelData;
    private long prevFrameTick = System.currentTimeMillis();
    private long lastAvg = 0;
    private double deltaTime = 0;


    public CameraPreview(Context context, Camera camera) {
        super(context);

        mCamera = camera;
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
        pixelData = new byte[(int)(previewSize.height * previewSize.width * 1.5)];
    }


    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.setDisplayOrientation(90);
            mCamera.startPreview();
            mCamera.addCallbackBuffer(pixelData);
        }
        catch (IOException e) {
            Log.e("surfaceCreated", "Error setting camera preview: " + e.getMessage());
        }

    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
    }

    public void destroyPreview() {
        surfaceDestroyed(mHolder);
    }
//    TODO: MIGHT NEED TO IMPLEMENT THIS
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        prevFrameTick = System.currentTimeMillis();
        pixelData = new byte[data.length];
        mCamera.addCallbackBuffer(pixelData);
        long sum = 0l;
        for (byte pixel: data) {
            sum += pixel;
        }
        sum = sum / data.length;
        //Log.e("Average: ", "" + sum);
        deltaTime += prevFrameTick;
        long delta = sum - lastAvg;

        if (Math.abs(delta) >= (40)) {
            Log.e("Delta, timeDiff", "" + (sum - lastAvg) + ", " + (deltaTime/1000));

            saveDelta(lastAvg, deltaTime);

            deltaTime = 0;

        }



        lastAvg = sum;
    }

    private void saveDelta(long delta, double deltaTime) {
        int index = (int)(delta / Math.abs(delta));
        boolean deltaBool = (index == 1);

        if (deltaTime < )

        MorsePacket packet = new MorsePacket(deltaBool, );

        ReaderActivity.savedTimings.add();
    }
}
