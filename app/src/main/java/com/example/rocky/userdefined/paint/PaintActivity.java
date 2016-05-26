package com.example.rocky.userdefined.paint;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.rocky.userdefined.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaintActivity extends AppCompatActivity {

    @BindView(R.id.root)
    FrameLayout mRoot;
    @BindView(R.id.seek_bar)
    SeekBar mSeekBar;

    @BindView(R.id.img)
    ImageView mImageView;

    private Bitmap mOriginBitmap,mTempBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        ButterKnife.bind(this);
        //
        //mRoot.addView(new MyView(this));

        mOriginBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
        mTempBitmap = Bitmap.createBitmap(mOriginBitmap.getWidth(),
                mOriginBitmap.getHeight(),Bitmap.Config.ARGB_8888);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bitmap = handleMatrixBitmap(progress);
                mImageView.setImageBitmap(bitmap);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private Bitmap handleMatrixBitmap(int progress){
        Canvas canvas = new Canvas(mTempBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(progress);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mOriginBitmap,0,0,paint);
        return mTempBitmap;

    }
}
