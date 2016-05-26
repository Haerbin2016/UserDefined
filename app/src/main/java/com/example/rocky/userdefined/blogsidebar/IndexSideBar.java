package com.example.rocky.userdefined.blogsidebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.rocky.userdefined.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Rocky on 2016/5/23.
 */
public class IndexSideBar extends View {
    //外部事件接口
    public interface ChooseListener {
        void onChoosed(int pos, String text);
    }

    private ChooseListener mChooseListener = null;

    public static String[] B = {
            "#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private List<String> mIndexCount = new ArrayList<>();
    private Paint mPaint = new Paint();

    private int mChoose = -1;

    private TextView mIndicatorTv = null;


    public IndexSideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initIndex();
    }

    private void initIndex() {
        for (String str : B) {
            mIndexCount.add(str);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / (mIndexCount.size() + 1); //获取每个字母的高度
        //画圆圈
        if (-1 == mChoose) {
            mPaint.setColor(Color.parseColor("#888888"));
        } else {
            mPaint.setColor(Color.parseColor("#fa7829"));
        }
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width / 2.0f, singleHeight / 2, singleHeight / 4, mPaint);
        mPaint.reset();

        //写字
        for (int i = 0; i < mIndexCount.size(); i++) {
            if (i == mChoose) {
                mPaint.setColor(Color.parseColor("#fa7829"));
            } else {
                mPaint.setColor(Color.parseColor("#888888"));
            }
            mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            mPaint.setAntiAlias(true);
            mPaint.setTextSize(22);
            mPaint.setTextAlign(Paint.Align.CENTER);
            //相对坐标设置为中间位置
            float xPos = width / 2;
            //给点中间线的位置,计算出baseline位置
            Paint.FontMetricsInt fm = mPaint.getFontMetricsInt();
            int center = singleHeight * (i + 1) + singleHeight / 2;
            int baseline = center + (fm.bottom - fm.top) / 2 - fm.bottom;
            canvas.drawText(mIndexCount.get(i), xPos, baseline, mPaint);
            mPaint.reset();

        }

    }

    //设置监听器
    public void setChooseListener(ChooseListener listener) {
        mChooseListener = listener;
    }

    public void setIndicatorTv(TextView tv) {
        mIndicatorTv = tv;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        int pos = 0; //取得字符的位置，默认 #

        //(int) (y / getHeight() * (mIndexCount + 1));

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pos = (int) (y / getHeight() * (mIndexCount.size() + 1));
                mChoose = pos - 1;
                if (null != mIndicatorTv) {
                    String text = mIndexCount.get(mChoose);
                    mIndicatorTv.setText(text);
                    mIndicatorTv.setVisibility(VISIBLE);
                }
                if(null != mChooseListener){
                    String text = mIndexCount.get(mChoose);
                    mChooseListener.onChoosed(mChoose,text);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                if (checkTouchInView(this, x, y)) {//事件在View范围内
                    pos = (int) (y / getHeight() * (mIndexCount.size() + 1));
                    mChoose = pos - 1;
                    if (null != mIndicatorTv) {
                        String text = mIndexCount.get(mChoose);
                        mIndicatorTv.setText(text);
                        mIndicatorTv.setVisibility(VISIBLE);
                    }
                    if(null != mChooseListener){
                        String text = mIndexCount.get(mChoose);
                        mChooseListener.onChoosed(mChoose,text);
                    }

                } else {//超出view范围
                    //mChoose = -1;
                    if (null != mIndicatorTv) {
                        mIndicatorTv.setVisibility(INVISIBLE);
                        //event.setAction(MotionEvent.ACTION_UP);
                        //dispatchTouchEvent(event);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                //Log.d("action=","action_up");
                //mChoose = -1;
                if(null != mIndicatorTv){
                    mIndicatorTv.setVisibility(GONE);
                }
                /*
                if(null != mChooseListener){
                    String text = mIndexCount.get(mChoose);
                    mChooseListener.onChoosed(mChoose,text);
                }*/
                break;
            default:
                break;


        }
        invalidate();
        return true;
    }

    /*
    * 判断touch是否在view中
    * */
    private boolean checkTouchInView(View view, float x, float y) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        int[] location = new int[2];
        //view.getLocationOnScreen(location);
        location[0] = 0;
        location[1] = 0;
        rect.left = location[0];
        rect.top = location[1];
        rect.right = rect.right + location[0];
        rect.bottom = rect.bottom + location[1];
        //Log.d("rect", "=" + rect);
        //Log.d("x=" + x, "y" + y);
        return rect.contains((int) x, (int) y);


    }
}
