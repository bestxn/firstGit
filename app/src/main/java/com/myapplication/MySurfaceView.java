package com.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by lxn on 2018/4/17.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    private SurfaceHolder mHolder;
    public boolean isDrawing;
    private Canvas mCanvas;
    public static int TIME_IN_FRAME = 30;
    private Path mPath;
    private Paint mPaint;
    private int x =50,y = 50,r=10;

    public MySurfaceView(Context context) {
        super(context);
        initView();
	initView();
	//修复bug01
//添加了新功能02
//伟哥修改了bug
//添加新功能03
        //伟哥提交代码到主流
    }

    //初始化
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        new Thread(this).start();
    }
// ｌｘｎ更新了代码
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        x = (int)event.getX();
        y = (int)event.getY();
        return true;
    }

    @Override
    public void run() {

        while(isDrawing){
            doDraw();
            try {
//                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
  /*       long startTime = System.currentTimeMillis();
          synchronized (mHolder){
           mCanvas = mHolder.lockCanvas();
              int x = 0;
              int y = 0;
              x+=1;
              y=(int)(100*Math.sin(x*2*Math.PI/180)+400);
              mPath.lineTo(x,y);
//              mCanvas.drawPaint(mPath);
              draw(mCanvas);
              mHolder.unlockCanvasAndPost(mCanvas);
          }

            long endTime = System.currentTimeMillis();

            int diffTime  = (int)(endTime - startTime);

            while(diffTime <= TIME_IN_FRAME) {
                diffTime = (int)(System.currentTimeMillis() - startTime);
                Thread.yield();
            }*/
        }

    }

    public void doDraw() {
        mCanvas = mHolder.lockCanvas(); // 获得画布对象，开始对画布画画
        mCanvas.drawRGB(0, 0, 0); // 把画布填充为黑色
        mCanvas.drawCircle(x, y, r, mPaint); // 画一个圆
        mHolder.unlockCanvasAndPost(mCanvas); // 完成画画，把画布显示在屏幕上
    }

    private void initView() {
        mHolder = getHolder();
        mHolder.addCallback(this);
//        mPath = new Path();
        mPaint =  new Paint();
        mPaint.setColor(Color.WHITE);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }
}
