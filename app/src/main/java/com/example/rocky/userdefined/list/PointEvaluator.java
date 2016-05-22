package com.example.rocky.userdefined.list;

import android.animation.TypeEvaluator;

/**
 * Created by Rocky on 2016/5/22.
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();

        int currentRedius = (int) (start + fraction * (end - start));

        return new Point(currentRedius);

    }
}
