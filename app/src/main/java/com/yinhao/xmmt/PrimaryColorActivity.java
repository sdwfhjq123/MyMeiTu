package com.yinhao.xmmt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class PrimaryColorActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView imageView;
    private SeekBar sbHue, sbSaturation, sbLum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private float mHue, mSaturation, mLum;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_color);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.onepiece);

        imageView = (ImageView) findViewById(R.id.imageview);
        sbHue = (SeekBar) findViewById(R.id.sb_hue);
        sbSaturation = (SeekBar) findViewById(R.id.sb_saturation);
        sbLum = (SeekBar) findViewById(R.id.sb_lum);

        sbHue.setOnSeekBarChangeListener(this);
        sbSaturation.setOnSeekBarChangeListener(this);
        sbLum.setOnSeekBarChangeListener(this);

        sbHue.setMax(MAX_VALUE);
        sbSaturation.setMax(MAX_VALUE);
        sbLum.setMax(MAX_VALUE);

        //初始设置在中间
        sbHue.setProgress(MID_VALUE);
        sbSaturation.setProgress(MID_VALUE);
        sbLum.setProgress(MID_VALUE);

        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_hue:
                mHue = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
                break;
            case R.id.sb_saturation:
                mSaturation = progress * 1.0f / MID_VALUE;
                break;
            case R.id.sb_lum:
                mLum = progress * 1.0f / MID_VALUE;
                break;
        }
        imageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap, mHue, mSaturation, mLum));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
