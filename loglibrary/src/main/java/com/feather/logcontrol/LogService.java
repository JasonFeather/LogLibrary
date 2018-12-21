package com.feather.logcontrol;

import android.content.Context;
import com.feather.logcontrol.Base.BaseLog;
import com.feather.logcontrol.listener.LogState;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public class LogService extends BaseLog {
    public static HashMap<Class,LogState> logStateMaps=new HashMap<>();
    public LogService(Context context, String pathName,boolean isErrorLog) {
        super(context, pathName);
    }

    public void setLogState(Class c) {
        setmLogState(c);
    }

    public void showLog(String tag,String msg){
        mLogState.log(tag,msg);
    }
    public void ShowLogAndWrite(String tag,String msg){
        mLogState.log(tag,msg);
        mLogState.writeLogToSdk(tag,msg);
    }
}
