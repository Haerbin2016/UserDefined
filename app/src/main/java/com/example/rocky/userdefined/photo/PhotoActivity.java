package com.example.rocky.userdefined.photo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rocky.userdefined.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoActivity extends AppCompatActivity  {
    private static final String TAG = "PhotoActivity";

    @BindView(R.id.imageID)
    ImageView mTextView;
    @BindView(R.id.btn_01)
    Button mButton0;
    @BindView(R.id.btn_02)
    Button mButton1;

    public static final int NONE = 0;
    public static final int PHOTOHRAPH = 1;// 拍照
    public static final int PHOTOZOOM = 2; // 缩放
    public static final int PHOTORESOULT = 3;// 结果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        //

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.d(TAG,"onActivityResult="+requestCode);
    }

    //
    @OnClick(R.id.btn_01)
    void btn_01(View view){ //相册
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);

        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,PHOTOZOOM);
    }
    @OnClick(R.id.btn_02)
    void btn_02(View view){ //拍照
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "temp.jpg")));
        System.out.println("============="
                + Environment.getExternalStorageDirectory());
        startActivityForResult(intent, PHOTOHRAPH);

    }


}
