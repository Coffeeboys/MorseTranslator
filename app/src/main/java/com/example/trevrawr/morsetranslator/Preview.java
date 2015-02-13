//package com.example.trevrawr.morsetranslator;
//
///**
// * Created by emreerhan on 2015-02-13.
// */
//import android.content.Context;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.ViewGroup;
//
//public class Preview extends ViewGroup implements SurfaceHolder.Callback {
//    SurfaceView mSurfaceView;
//    SurfaceHolder mSurfaceHolder;
//
//    Preview(Context context) {
//        super(context);
//
//        mSurfaceView = new SurfaceView(context);
//        addView(mSurfaceView);
//
//        mSurfaceHolder = mSurfaceView.getHolder();
//        mSurfaceHolder.addCallback(this);
//        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//    }
//}
