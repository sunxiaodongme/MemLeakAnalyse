package com.example.sunxiaodong.memleakanalyse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sunxiaodong on 2016/1/28.
 * 注意：注释的代码为处理该种内存泄漏的方法
 */
public class InstanceActivity extends AppCompatActivity {

    private static final String NAME = InstanceActivity.class.getSimpleName();
    private static final String TAG = "sxd";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance);
        initData();
    }

    private void initData() {
        Instance.getInstance(this);
//        Instance.getInstance(this.getApplicationContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, NAME + "--onDestroy++");
    }

}