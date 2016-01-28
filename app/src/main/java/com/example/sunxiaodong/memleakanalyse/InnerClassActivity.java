package com.example.sunxiaodong.memleakanalyse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sunxiaodong on 2016/1/28.
 */
public class InnerClassActivity extends AppCompatActivity {

    private static final String NAME = InnerClassActivity.class.getSimpleName();
    private static final String TAG = "sxd";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_class);
        initData();
    }

    private void initData() {
        Instance.getInstance(this.getApplicationContext()).setListener(new Listener() {//匿名内部类
            @Override
            public void listener() {

            }
        });
//        Instance.getInstance(this.getApplicationContext()).setListener(new MyListener());//内部类
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, NAME + "--onDestroy++");
    }

    class MyListener implements Listener {

        @Override
        public void listener() {

        }
    }

}