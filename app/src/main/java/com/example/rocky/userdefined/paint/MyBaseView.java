package com.example.rocky.userdefined.paint;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Rocky on 2016/5/23.
 * 测试基本的图形
 */
public class MyBaseView extends View {

    private Paint mPaint = new Paint();

    public MyBaseView(Context context) {
        super(context);

    }

    public MyBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);

        Path path = new Path();
        path.moveTo(10,10);
        path.lineTo(10,100);
        path.lineTo(300,100);
        path.close();
        //canvas.drawPath(path,mPaint);

        Path path1 = new Path();
        //RectF rect1 = new RectF(50,50,240,200);
        //path1.addRect(rect1, Path.Direction.CW);
        //
        RectF rect2 = new RectF(290,50,480,200);
        path1.addRect(rect2, Path.Direction.CCW);

        canvas.drawPath(path1,mPaint);
        //canvas.save();

        String str = "风潇潇兮易水寒";
        //mPaint.setColor(Color.BLUE);
        //mPaint.setTextSize(35);
        //canvas.drawTextOnPath(str,path1,0,18,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(80);
        canvas.drawText(str,10,300,mPaint);

        AssetManager assetManager = getContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager,"fonts/jian_luobo.ttf");
        mPaint.setTypeface(typeface);
        canvas.drawText(str,50,100,mPaint);

    }
}
