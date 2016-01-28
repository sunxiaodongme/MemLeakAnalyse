package com.example.sunxiaodong.memleakanalyse;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sunxiaodong on 2016/1/28.
 * 注意：注释的代码为处理该种内存泄漏的方法
 */
public class HandlerActivity extends AppCompatActivity {

    private static final String NAME = HandlerActivity.class.getSimpleName();
    private static final String TAG = "sxd";

    private Handler mHandler;
//    private Runnable mRunnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        initData();
    }

    private void initData() {
        mHandler = new Handler();
        /*mRunnable = new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, NAME + "--5分钟后执行的任务++");
            }
        };*/
//        mHandler.postDelayed(mRunnable, 5 * 60 * 1000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, NAME + "--5分钟后执行的任务++");
            }
        }, 5 * 60 * 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mHandler.removeCallbacks(mRunnable);
        Log.i(TAG, NAME + "--onDestroy++");
    }

}
