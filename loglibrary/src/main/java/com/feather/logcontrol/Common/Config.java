package com.feather.logcontrol.Common;

import android.os.Environment;

import java.text.SimpleDateFormat;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public class Config {
    public static final SimpleDateFormat SDF2 = new SimpleDateFormat("MM-dd HH:mm:ss");
    public static  long HPNS_LOG_MAX_FILE_SIZE = 10 * 1024 * 1024;
    public static String basePath = Environment.getExternalStorageDirectory()
            .toString() + "/hcbbug/";
}
