package com.example.rocky.userdefined.list;

import android.animation.TypeEvaluator;

/**
 * Created by Rocky on 2016/5/22.
 */
public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int start = (int) startValue;
        int end = (int) endValue;
        int value = (int) (start + fraction * (end - start));
        char charValue = (char) value;
        return charValue;

    }
}
