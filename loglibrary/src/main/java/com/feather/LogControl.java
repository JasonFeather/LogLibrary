package com.feather;

import android.content.Context;

import com.feather.logcontrol.Common.Config;
import com.feather.logcontrol.LogService;
import com.feather.logcontrol.UnCeHandler;
import com.feather.logcontrol.listener.LogState;

import java.util.ArrayList;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public class LogControl {
    private static LogService logService;
    public static void init(Context context, String namePath, boolean isErrorLog) {
        if (null == logService) {
            logService = new LogService(context, namePath, isErrorLog);
        }
        if (isErrorLog) {
            UnCeHandler.getInstance().init(context, namePath);
        }
    }

    /**
     * 修改日志本地大小 单位兆
     * @param size
     */
    public static void setLogSize(int size){
        Config.HPNS_LOG_MAX_FILE_SIZE=size*1024 * 1024;
    }

    public static LogService setLogDate(Class logState) {
        logService.setLogState(logState);
        return logService;
    }

}
