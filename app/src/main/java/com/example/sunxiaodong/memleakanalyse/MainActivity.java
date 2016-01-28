package com.example.sunxiaodong.memleakanalyse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGoStaticReference;
    private Button mGoHandler;
    private Button mGoEventBus;
    private Button mGoInstance;
    private Button mGoInnerClass;
    private Button mGoBaiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mGoStaticReference = (Button) this.findViewById(R.id.go_static_reference);
        mGoStaticReference.setOnClickListener(this);
        mGoHandler = (Button) this.findViewById(R.id.go_handler);
        mGoHandler.setOnClickListener(this);
        mGoEventBus = (Button) this.findViewById(R.id.go_eventbus);
        mGoEventBus.setOnClickListener(this);
        mGoInstance = (Button) this.findViewById(R.id.go_instance);
        mGoInstance.setOnClickListener(this);
        mGoInnerClass = (Button) this.findViewById(R.id.go_inner_class);
        mGoInnerClass.setOnClickListener(this);
        mGoBaiduMap = (Button) this.findViewById(R.id.go_baidu_map);
        mGoBaiduMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_static_reference:
                goStaticReference();
                break;
            case R.id.go_handler:
                goHandler();
                break;
            case R.id.go_eventbus:
                goEventBus();
                break;
            case R.id.go_instance:
                goInstance();
                break;
            case R.id.go_inner_class:
                goInnerClass();
                break;
            case R.id.go_baidu_map:
                goBaiduMap();
                break;
        }
    }

    private void goStaticReference() {
        Intent intent = new Intent(this, StaticReferenceActivity.class);
        startActivity(intent);
    }

    private void goHandler() {
        Intent intent = new Intent(this, HandlerActivity.class);
        startActivity(intent);
    }

    private void goEventBus() {
        Intent intent = new Intent(this, EventBusActivity.class);
        startActivity(intent);
    }

    private void goInstance() {
        Intent intent = new Intent(this, InstanceActivity.class);
        startActivity(intent);
    }

    private void goInnerClass() {
        Intent intent = new Intent(this, InnerClassActivity.class);
        startActivity(intent);
    }

    private void goBaiduMap() {
        Intent intent = new Intent(this, BaiduMapActivity.class);
        startActivity(intent);
    }

}
