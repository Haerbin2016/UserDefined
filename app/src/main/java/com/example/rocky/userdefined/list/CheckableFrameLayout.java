package com.example.rocky.userdefined.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * Created by Rocky on 2016/5/22.
 */
public class CheckableFrameLayout extends FrameLayout implements Checkable {

    private boolean mChecked = false;

    public CheckableFrameLayout(Context context) {
        super(context);
    }

    public CheckableFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setChecked(boolean checked) {
        if(mChecked != checked){
            mChecked = checked;
            refreshDrawableState();
            for(int i=0;i<getChildCount();i++){
                View child = getChildAt(i);
                if(child instanceof CheckBox){
                    ((CheckBox)child).setChecked(mChecked);
                }
            }

        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }
}
