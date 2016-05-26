package com.example.rocky.userdefined.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.rocky.userdefined.R;

/**
 * Created by Rocky on 2016/5/22.
 */
public class MyView extends View {
    private Context mContext = null;
    private Paint mPaint = new Paint();
    private Bitmap mBitmap = null;
    public MyView(Context context) {
        super(context);
        mContext = context;
        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.dog);
    }
    /*
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setShadowLayer(10,15,15,Color.BLUE);

        canvas.drawRGB(255,255,255);
        canvas.drawCircle(190,200,150,paint);
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setARGB(255,200,100,100);
        canvas.drawRect(0,0,500,600,mPaint);

        canvas.translate(550,0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
           0,0,0,0,0,
           0,0,0,0,0,
           0,0,1,0,0,
           0,0,0,1,0
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0,0,500,600,mPaint);

    } */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //
        //Paint paint = new Paint();
        mPaint.reset();
        canvas.drawBitmap(mBitmap,null,new Rect(0, 0, 500, 500 * mBitmap.getHeight() / mBitmap.getWidth()), mPaint);

        canvas.translate(510,0);
        ColorMatrix matrix = new ColorMatrix(new float[]{
           1.2f,0,0,0,0,
           0,1.2f,0,0,0,
           0,0,1.2f,0,0,
           0,0,0,1.2f,0,
        });

        mPaint.setColorFilter(new ColorMatrixColorFilter(matrix));
        canvas.drawBitmap(mBitmap,null,new Rect(0, 0, 500, 500 * mBitmap.getHeight() / mBitmap.getWidth()), mPaint);


    }
}
