package com.example.sunxiaodong.memleakanalyse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * Created by sunxiaodong on 2016/1/28.
 * 注意：注释的代码为处理该种内存泄漏的方法
 */

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String NAME = EventBusActivity.class.getSimpleName();
    private static final String TAG = "sxd";

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        initView();
    }

    private void initView() {
        mTextView = (TextView) this.findViewById(R.id.textview);
        mButton = (Button) this.findViewById(R.id.button);
        mButton.setOnClickListener(this);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button :
                sendEventBus();
                break;
        }
    }

    private void sendEventBus() {
        Event event = new Event();
        event.setContent("EventBus未进行反注册泄漏");
        EventBus.getDefault().post(event);
    }

    public void onEventMainThread(Event event) {
        mTextView.setText(event.getContent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
        Log.i(TAG, NAME + "--onDestroy++");
    }

    /**
     * 发送事件
     */
    class Event {

        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}