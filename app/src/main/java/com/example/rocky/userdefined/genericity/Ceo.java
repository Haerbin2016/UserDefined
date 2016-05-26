package com.example.rocky.userdefined.genericity;

import android.location.GpsStatus;

/**
 * Created by Rocky on 2016/5/24.
 */
public class Ceo extends Manager implements GpsStatus.Listener {
    public Ceo(String name) {
        super(name);
    }

    @Override
    public void onGpsStatusChanged(int event) {

    }
}
