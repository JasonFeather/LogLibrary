package com.feather.logcontrol.listener;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public interface LogStateListener {
    void log(String tag, String msg);//日志输出
    void writeLogToSdk(String tag, String msg);//写日志
}
