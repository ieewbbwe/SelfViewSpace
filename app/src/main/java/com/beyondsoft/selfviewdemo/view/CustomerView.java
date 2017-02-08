package com.beyondsoft.selfviewdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import com.beyondsoft.selfviewdemo.R;

import static android.graphics.Paint.HINTING_ON;

/**
 * Created by mxh on 2017/2/8.
 * Describe：
 */

public class CustomerView extends View implements Runnable {

    private Paint mPaint;
    private int radius;
    private Bitmap bitmap;
    // 生成色彩矩阵
    ColorMatrix colorMatrix = new ColorMatrix(new float[]{
            0, 1, 0, 0, 0,
            1, 0, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0,
    });

    public CustomerView(Context context) {
        this(context, null);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initBitmap();
    }

    private void initBitmap() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.iv);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);
        mPaint.setHinting(HINTING_ON);
        //mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        //mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));

        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawLine(0, 0, 100, 100, mPaint);
        //canvas.drawCircle(100, 100, radius, mPaint);
        canvas.drawBitmap(bitmap, 100, 100, mPaint);
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (radius <= 100) {
                    radius += 10;
                    postInvalidate();
                } else {
                    radius = 0;
                }
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
