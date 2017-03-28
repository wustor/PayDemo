package com.fatchao.paydemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by fatchao
 * 日期  2017-03-28.
 * 邮箱  18521092686@163.com
 */

public class BaseApplication extends Application {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
