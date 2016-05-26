package com.example.rocky.userdefined.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Rocky on 2016/5/23.
 */
public class MyRegionView extends View {
    private Paint mPaint = new Paint();

    public MyRegionView(Context context) {
        super(context);
    }

    public MyRegionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.RED);
        //
        /*
        Path pathOval = new Path();
        RectF rect = new RectF(50,50,200,500);
        pathOval.addOval(rect, Path.Direction.CCW);
        //
        Region region = new Region();
        region.setPath(pathOval,new Region(50,50,200,200));
        drawRegion(canvas,region,mPaint);
        */
        Rect rect1 = new Rect(100,100,400,200);
        Rect rect2 = new Rect(200,0,300,300);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);
        region1.op(region2, Region.Op.INTERSECT);

        Paint paintFill = new Paint();
        paintFill.setAntiAlias(true);
        paintFill.setColor(Color.BLUE);
        paintFill.setStyle(Paint.Style.FILL);
        canvas.translate(300,300);
        drawRegion(canvas,region1,paintFill);


    }

    private void drawRegion(Canvas canvas,Region region,Paint paint){
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)){
            canvas.drawRect(rect,paint);
        }

    }
}
