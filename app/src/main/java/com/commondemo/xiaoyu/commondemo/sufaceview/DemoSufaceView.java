package com.commondemo.xiaoyu.commondemo.sufaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.commondemo.xiaoyu.utils.Logger;

/**
 * Created by Xiaoyu on 2018/6/12.
 */

public class DemoSufaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder mHolder = null;
    private Canvas mCanvas = null;

    public DemoSufaceView(Context context) {
        super(context);
    }

    public DemoSufaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DemoSufaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Logger.INSTANCE.d("DemoSufaceView", String.format("format:%s, width:%s, height:%s", format, width, height ));
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    /**
     * 子线程中绘制
     */
    @Override
    public void run() {

    }

    private void onDraw(){
        mCanvas = mHolder.lockCanvas();

        mHolder.unlockCanvasAndPost(mCanvas);


    }
}
