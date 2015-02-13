package com.example.trevrawr.morsetranslator;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;


public class ReaderActivity extends Activity {
    public Camera mCamera;
    public CameraPreview mPreview;
    private List<Camera.Size> mSupportedPreviewSizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);


        if (checkCameraHardware(this)) {
            openCamera();
        }

        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout)findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewFpsRange(parameters.getSupportedPreviewFpsRange().get(0)[1], parameters.getSupportedPreviewFpsRange().get(0)[1]);
//        parameters.setPreviewFpsRange(30000, 30000);
        parameters.setExposureCompensation(parameters.getMinExposureCompensation());
        mCamera.setParameters(parameters);
        mCamera.setPreviewCallbackWithBuffer(mPreview);

        Button returnButton = (Button)findViewById(R.id.button_return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
                finish();
            }
        });
    }

    public void onPause() {
        super.onPause();

        //mPreview.destroyPreview();
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mPreview.getHolder().removeCallback(mPreview);
            mCamera.release();
            mCamera = null;
        }

    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean openCamera() {
        boolean qOpened = false;


        try {
            //releaseCameraAndPreview();
            mCamera = Camera.open();
            qOpened = (mCamera != null);
        }

        catch (Exception e) {
            Log.e(getString(R.string.app_name), "Failed to open camera");
            e.printStackTrace();
        }
        return qOpened;
    }

//    private void releaseCameraAndPreview() {
//        //mPreview.setCamera(null);
//        if (mCamera == null) {
//            mCamera.release();
//            mCamera = null;
//        }
//    }
//
//    public void setCamera(Camera camera) {
//        if (mCamera == camera) return;
//
//        stopPreviewAndFreeCamera();
//
//        mCamera = camera;
//        if (mCamera != null) {
//            List<Camera.Size> localSizes = mCamera.getParameters().getSupportedPreviewSizes();
//            mSupportedPreviewSizes = localSizes;
//            requestLayout();
//        }
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reader, menu);
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
