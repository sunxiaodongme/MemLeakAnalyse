package com.example.sunxiaodong.memleakanalyse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by sunxiaodong on 2016/1/27.
 */
public class StaticReferenceActivity extends AppCompatActivity {

    private static final String NAME = StaticReferenceActivity.class.getSimpleName();
    private static final String TAG = "sxd";

    public static StaticReferenceActivity sStaticReferenceActivity;
    private static Bitmap sBitmap;

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_reference);
        sStaticReferenceActivity = this;
        initView();
    }

    private void initView() {
        mImageView = (ImageView) this.findViewById(R.id.image_view);
        sBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image);
        mImageView.setImageBitmap(sBitmap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, NAME + "--onDestroy++");
    }

}
