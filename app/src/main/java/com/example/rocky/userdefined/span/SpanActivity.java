package com.example.rocky.userdefined.span;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;

import com.example.rocky.userdefined.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.ButterKnife;

/*
* 各种Span类处理
* */
public class SpanActivity extends AppCompatActivity {

    private int x;
    private int y;
    private int z;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span);
        ButterKnife.bind(this);
        //
        int xx = 0;
        int yy = 1;
        List<String> list = new ArrayList<>();
        String str = "asdf1234";

    }
}
