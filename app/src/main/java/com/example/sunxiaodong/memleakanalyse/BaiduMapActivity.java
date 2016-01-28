package com.example.sunxiaodong.memleakanalyse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

/**
 * Created by sunxiaodong on 2016/1/28.
 * 注意：注释的代码为处理该种内存泄漏的方法
 */
public class BaiduMapActivity extends AppCompatActivity {

    private static final String NAME = BaiduMapActivity.class.getSimpleName();
    private static final String TAG = "sxd";

    private MapView mBaiduMapView;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidumap);
        initView();
    }

    private void initView() {
        mBaiduMapView = (MapView) this.findViewById(R.id.mapview);
        //地图初始化
        mBaiduMapView.showScaleControl(false);
        mBaiduMapView.showZoomControls(false);
        mBaiduMap = mBaiduMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);//普通地图
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mBaiduMap.clear();
//        mBaiduMapView.onDestroy();
        Log.i(TAG, NAME + "--onDestroy++");
    }

}