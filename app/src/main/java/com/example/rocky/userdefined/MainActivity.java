package com.example.rocky.userdefined;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rocky.userdefined.list.CharEvaluator;
import com.example.rocky.userdefined.list.ListActivity;
import com.example.rocky.userdefined.list.MyEvaluatorFloat;
import com.example.rocky.userdefined.list.MyPointView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
* 自定义控件
* */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.btn_list)
    Button mButtonList;
    @BindView(R.id.my_point_view)
    MyPointView mMyPointView;

    private Animation mScaleAnimation;
    private Animation mTranslateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mScaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scaleanim);
        mTranslateAnimation = AnimationUtils.loadAnimation(this,R.anim.translateanim);
    }


    @OnClick(R.id.btn_animation)
    void btn_animation(View view){
       // tv.startAnimation(mScaleAnimation);
       // mButtonList.startAnimation(mTranslateAnimation);
        doAnimation();
   }
    //属性动画
    private void doAnimation(){
        /*
        ValueAnimator animator = ValueAnimator.ofFloat(0f,400f,50f,300f);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float floatValue = (Float)animation.getAnimatedValue();
                int value = floatValue.intValue();
                mButtonList.layout(mButtonList.getLeft(),value,mButtonList.getRight(),value+mButtonList.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        //animator.setEvaluator(new MyEvaluatorFloat());
        //animator.setInterpolator(new BounceInterpolator());
        animator.start();
       */
        /*
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int)animation.getAnimatedValue();
                mButtonList.setBackgroundColor(value);
            }
        });
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
        */
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),
                new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char value = (char)animation.getAnimatedValue();
                mButtonList.setText(String.valueOf(value));
            }
        });
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

//  显示list Activity
    @OnClick(R.id.btn_list)
    void btn_list(View view){

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_point)
    void btn_point(View view){
        //mMyPointView.doPointAnim();
        //ObjectAnimator animator = ObjectAnimator.ofFloat(mButtonList,"alpha",1,0,1);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mButtonList,"rotationY",0,180);
        animator.setDuration(3000);
        animator.start();
    }
}
