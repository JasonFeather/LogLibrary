package com.loglibrary.wing.log;

import android.app.Application;

import com.feather.LogControl;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogControl.init(getApplicationContext(),"bbb",true);

    }
}
