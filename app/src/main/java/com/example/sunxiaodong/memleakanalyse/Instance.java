package com.example.sunxiaodong.memleakanalyse;

import android.content.Context;

/**
 * Created by sunxiaodong on 2016/1/28.
 */
public class Instance {

    private static Instance sInstance;

    private Context mContext;
    private Listener mListener;

    private Instance(Context context) {
        mContext = context;
    }

    public static synchronized Instance getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Instance(context);
        }
        return sInstance;
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

}
