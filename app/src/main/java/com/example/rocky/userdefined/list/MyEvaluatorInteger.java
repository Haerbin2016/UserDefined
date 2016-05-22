package com.example.rocky.userdefined.list;

import android.animation.TypeEvaluator;

/**
 * Created by Rocky on 2016/5/22.
 */
public class MyEvaluatorInteger implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int) (startValue + 200 + fraction * (endValue - startValue));
    }
}
