package com.example.rocky.userdefined;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rocky.userdefined.list.ListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
* 自定义控件
* */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;

    private Animation mScaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mScaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scaleanim);
    }


    @OnClick(R.id.btn_animation)
    void btn_animation(View view){
        tv.startAnimation(mScaleAnimation);


//        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
    }
//  显示list Activity
    @OnClick(R.id.btn_list)
    void btn_list(View view){

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

}
