package com.feather.Utils;

import android.os.Environment;

/**
 * zhangjinqi
 * 类的意图:获取sd卡路径
 */

public class CommonUtilImage {

    public static String getPath() {
        if (hasSDCard()) {
            //获取SDCard卡目录
            return Environment.getExternalStorageDirectory().toString()
                    + "/dianping/data/";// filePath:/sdcard/
        } else {
            //获取缓存目录
            return Environment.getDataDirectory().toString()
                    + "/dianping/data/"; // filePath: /data/data/
        }
    }
    //判断SDCard是否存在
    public static boolean hasSDCard() {
        String status = Environment.getExternalStorageState();
        if (!status.equals(Environment.MEDIA_MOUNTED)) {
            return false;
        }
        return true;
    }

}
