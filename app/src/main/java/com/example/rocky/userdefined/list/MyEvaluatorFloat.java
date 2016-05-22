package com.example.rocky.userdefined.list;

import android.animation.TypeEvaluator;

/**
 * Created by Rocky on 2016/5/22.
 */
public class MyEvaluatorFloat implements TypeEvaluator<Float> {
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        float start = startValue.floatValue();
        float end = endValue.floatValue();
        return (float) (start + 200.0 + fraction *(end-start));
    }
}
