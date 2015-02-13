package com.example.trevrawr.morsetranslator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.hardware.Camera;
import java.lang.System;




public class TransmitterActivity extends ActionBarActivity {

    Camera cam;
    Camera.Parameters camParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmitter);
        createCamera();
        cameraOn();
    }

    public void waitForSeconds(float seconds){
        float startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + seconds){

        }
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
