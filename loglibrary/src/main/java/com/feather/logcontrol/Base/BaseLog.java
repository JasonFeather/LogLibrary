package com.feather.logcontrol.Base;

import android.content.Context;
import com.feather.State.ErrorLog;
import com.feather.logcontrol.Common.Config;
import com.feather.logcontrol.LogService;
import com.feather.logcontrol.listener.LogState;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public abstract class BaseLog {
    private Context context;
    private String mPathName;
    protected LogState mLogState;
    public BaseLog(Context context, String pathName) {
        this.mPathName =pathName;
        this.context = context;
    }

    protected void setmLogState(Class mLogState) {
        try {
            if (mLogState.equals(ErrorLog.class)) {
                LogState logStateTemp = LogService.logStateMaps.get(mLogState);
                if (logStateTemp != null) {
                    this.mLogState = logStateTemp;
                } else {
                    LogState logState = (LogState) mLogState.newInstance();
                    this.mLogState = logState;
                    this.mLogState.setPathName(mPathName, context);
                    LogService.logStateMaps.put(mLogState, logState);
                }
            }
        } catch (Exception e) {
            e.toString();

        }
        ;
    }
}
