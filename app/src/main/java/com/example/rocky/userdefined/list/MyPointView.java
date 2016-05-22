package com.example.rocky.userdefined.list;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by Rocky on 2016/5/22.
 */
public class MyPointView extends View {

   Point mCurPoint = null;

    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null != mCurPoint) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mCurPoint.getRadius(),paint);
        }

    }

    public void doPointAnim(){
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200),
                new Point(200),new Point(20));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurPoint = (Point)animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(3000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();

    }


}
