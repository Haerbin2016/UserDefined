package com.example.rocky.userdefined.popwin;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rocky.userdefined.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopWinActivity extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow mPopupWindow = null;

    @BindView(R.id.pop_win_menu)
    TextView tvMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pop_win);
        ButterKnife.bind(this);
        //
    }

    @OnClick(R.id.btn_popwin_btn)
    void btn_popwin_btn(View view){
        showPopupWindow();
    }
    private void  showPopupWindow(){
        View viewContent = LayoutInflater.from(PopWinActivity.this).inflate(R.layout.pop_layout,null);
        mPopupWindow = new PopupWindow(viewContent);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv1 = (TextView)viewContent.findViewById(R.id.pop_computer);
        TextView tv2 = (TextView)viewContent.findViewById(R.id.pop_financial);
        TextView tv3 = (TextView)viewContent.findViewById(R.id.pop_manager);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

        mPopupWindow.setAnimationStyle(R.style.context_MenuAnim);
        //mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x11000000));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.showAsDropDown(tvMenu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pop_computer:
                Toast.makeText(PopWinActivity.this,"click computer",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;
            case R.id.pop_financial:
                Toast.makeText(PopWinActivity.this,"click financial",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;
            case R.id.pop_manager:
                Toast.makeText(PopWinActivity.this,"click manager",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;
            default:
                break;
        }

    }
}
