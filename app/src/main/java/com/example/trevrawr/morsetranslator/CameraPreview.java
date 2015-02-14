package com.example.trevrawr.morsetranslator;

/**
* Created by emreerhan on 2015-02-13.
*/
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import EncoderDecoder.EncoderDecoder;
import EncoderDecoder.MorsePacket;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {
    private final int ERROR_THRESHOLD = 3;
    private final int LETTER_SPACE = 3;
    private final int WORD_SPACE = 7;
    private Camera mCamera;
    private SurfaceHolder mHolder;
    private byte[] pixelData;
    private long prevFrameTick = System.currentTimeMillis();
    private long lastAvg = 0;
    private double deltaTime = 0;
    private double deltaTimeInSeconds = 0;
    private ArrayList<MorsePacket> characterPackets;


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
        pixelData = new byte[data.length];
        mCamera.addCallbackBuffer(pixelData);
        long sum = 0l;
        for (byte pixel: data) {
            sum += pixel;
        }
        sum = sum / data.length;
        //Log.e("Average: ", "" + sum);
        deltaTime += System.currentTimeMillis() - prevFrameTick;
        long delta = sum - lastAvg;

        deltaTimeInSeconds = deltaTime / 1000;

        if (deltaTimeInSeconds > 5) {
            //outputMessage(decodeArray());
            //Log.e("Timeout", "Hello World");
        }
        //Log.e("DeltaSeconds", "" + deltaTimeInSeconds);
        if (Math.abs(delta) >= (10)) {
            Log.e("Delta, timeDiff", "" + (sum - lastAvg) + ", " + deltaTimeInSeconds);

            saveDelta(lastAvg, deltaTime);

            deltaTime = 0;

        }


        //outputMessage(decodeArray());
        lastAvg = sum;
        prevFrameTick = System.currentTimeMillis();

    }

    private void outputMessage(String s) {
       // OutputFragment dialog = new OutputFragment();
        Log.e("String: ", s);


    }

    private String decodeArray() {
        EncoderDecoder decoder = new EncoderDecoder();
        return decoder.decode(ReaderActivity.savedTimings);
    }

    private void saveDelta(long delta, double deltaTime) {
        if (delta == 0) return;
        //Log.e("SaveDelta", "Line 2");
        int index = (int)(Math.signum((double)delta));
//        Log.e("SaveDelta", "Line 4");
        boolean deltaBool = (index == 1);
//        Log.e("SaveDelta", "Line 6");

        int length = 0;

        if (deltaTime <= ERROR_THRESHOLD * MorsePacket.TIME_UNIT) {
            length = 1;
//            Log.e("SaveDelta", "If 1");

        }

        else if (deltaTime > ERROR_THRESHOLD * MorsePacket.TIME_UNIT
                || deltaTime <= ERROR_THRESHOLD * LETTER_SPACE * MorsePacket.TIME_UNIT) {
            length = LETTER_SPACE;
//            Log.e("SaveDelta", "If 2");

        }

        else {
            length = WORD_SPACE;
        }

        if (deltaBool == false && length == LETTER_SPACE) {
//            Log.e("SaveDelta", "If set2 1");
            ReaderActivity.savedTimings.add(characterPackets);
            characterPackets = new ArrayList<MorsePacket>();
        }
        else if (deltaBool == false && length == WORD_SPACE) {
            ReaderActivity.savedTimings.add(characterPackets);

            characterPackets = new ArrayList<MorsePacket>();
            characterPackets.add(new MorsePacket(false, WORD_SPACE));
            ReaderActivity.savedTimings.add(characterPackets);

            characterPackets = new ArrayList<MorsePacket>();
        }

        else {
//            Log.e("SaveDelta", "Last else");
            MorsePacket packet = new MorsePacket(deltaBool, length);
//            Log.e("SaveDelta", "After packet");
//            Log.e("Packet", "" + deltaBool + " " + length);
            try {
                characterPackets.add(packet);

            }
            catch (Exception e) {
                //Log.e("Exception", e.getMessage());
            }
//            Log.e("SaveDelta", "After add");

        }
    }
}
