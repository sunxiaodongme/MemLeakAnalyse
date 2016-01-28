package com.example.sunxiaodong.memleakanalyse;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by sunxiaodong on 2016/1/28.
 */
public class MemLeakAnalyseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());//初始化百度地图
    }

}
