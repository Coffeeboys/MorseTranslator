package com.example.trevrawr.morsetranslator;

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
import android.widget.Toast;

import java.util.List;


public class ReaderActivity extends ActionBarActivity {
    public Camera mCamera;
    private List<Camera.Size> mSupportedPreviewSizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        if (checkCameraHardware(this)) {
            //openCamera();
            Toast t = new Toast(this);
            t.setText("Camera exists");
            t.show();
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

//    private boolean openCamera(int id) {
//        boolean qOpened = false;
//
//        try {
//            releaseCameraAndPreview();
//            mCamera = Camera.open(id);
//            qOpened = (mCamera != null);
//        }
//
//        catch (Exception e) {
//            Log.e(getString(R.string.app_name), "Failed to open camera");
//            e.printStackTrace();
//        }
//        return qOpened;
//    }
//
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
