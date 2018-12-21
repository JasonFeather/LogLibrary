package com.feather.State;

import android.util.Log;

import com.feather.logcontrol.listener.LogState;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public class InfoLog extends LogState {

    @Override
    public void log(String tag, String msg) {
        Log.i(tag, "thread Id: " + Thread.currentThread().getId() + "  " + msg);
    }
    @Override
    public void writeLogToSdk(String tag, String msg) {
        appendLog(tag + "\t" + "thread Id: " + Thread.currentThread().getId() + "  "
                + msg,1);
    }

}
