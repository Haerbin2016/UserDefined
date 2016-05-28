package com.example.rocky.userdefined.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.rocky.userdefined.R;

import java.io.IOException;

/**
 * Created by Rocky on 2016/5/26.
 */
public class MusicService extends Service {
    private static final String TAG = "Music Service";
    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        if (null == mMediaPlayer) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.sky);
            mMediaPlayer.setLooping(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        if (null != mMediaPlayer) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
    }

    @Override
    public void onStart(Intent intent, int startId) {
        //super.onStart(intent, startId);
        Log.d("TAG", "onStart");
        if (null != intent) {
            Bundle bundle = intent.getExtras();
            if (null != bundle) {
                int op = bundle.getInt("op");
                switch (op) {
                    case 1:
                        play();
                        break;
                    case 2:
                        stop();
                        break;
                    case 3:
                        pause();
                        break;
                    default:
                        break;

                }
            }
        }
    }

    //
    private void play() {
        ///*
        try {
            if (!mMediaPlayer.isPlaying()) {
                mMediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//*/
        Log.d(TAG,"play");
        Toast.makeText(getApplicationContext(),"play",Toast.LENGTH_SHORT).show();
    }

    private void pause() {
        if (null != mMediaPlayer && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    private void stop() {
        if (null != mMediaPlayer) {
            mMediaPlayer.stop();
            try {
                mMediaPlayer.prepare();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
