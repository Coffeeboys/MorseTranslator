package com.example.trevrawr.morsetranslator;

import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Camera;
import java.lang.System;

import EncoderDecoder.MorsePacket;


public class TransmitterActivity extends ActionBarActivity {
    Camera cam;
    Camera.Parameters camParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmitter);
        createCamera();
        while (true){
            cameraOnForSeconds(1000);
            waitForSeconds(1000);
        }

    }

    public void waitForSeconds(long seconds){
        Long startTime = System.currentTimeMillis();
        Log.d("time", startTime.toString());
        while (System.currentTimeMillis() < startTime + seconds){

        }
    }

    public void cameraOnForSeconds(long seconds){
        cameraOn();
        waitForSeconds(seconds);
        cameraOff();
    }

    public void createCamera(){
        cam = Camera.open();
        cam.startPreview();
        camParameters = cam.getParameters();
    }

    public void cameraOn(){
        camParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(camParameters);
    }

    public void cameraOff(){
        camParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        cam.setParameters(camParameters);
    }

    public void closeCamera(){
        cam.stopPreview();
        cam.release();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transmitter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
