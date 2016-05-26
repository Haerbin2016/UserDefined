package com.example.rocky.userdefined.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.rocky.userdefined.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayMusicActivity extends AppCompatActivity {

    private static final TAG = "PlayMusic"
    private static final String OP = "op";

    private Intent mIntent = null;
    private Bundle mBundle = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_play_music);
        ButterKnife.bind(this);
        //
        mBundle = new Bundle();
        mIntent = new Intent("org.allin.android.musicService");
    }

    private void startMyService(int op){

        mBundle.putBundle(OP,op);
        startService(mIntent);
    }

    /*事件*/
    @OnClick(R.id.btn_play)
    void btn_play(View view){
        Log.d(TAG,"onClick:play")
        startMyService(1);
    }
    //stop
    @OnClick(R.id.btn_stop)
    void btn_stop(View view){
        Log.d(TAG,"onClick:stop")
        startMyService(2);
    }
    //pause
    @OnClick(R.id.btn_pause)
    void btn_pause(View view){
        Log.d(TAG,"onClick:pause")
        startMyService(3);
    }
    //exit
    @OnClick(R.id.btn_exit)
    void btn_exit(View view){
        Log.d(TAG,"onClick:exit");
        stopService(mIntent);

    }
    //Close
    @OnClick(R.id.btn_close)
    void btn_close(View view){
        this.finish();
    }
}
