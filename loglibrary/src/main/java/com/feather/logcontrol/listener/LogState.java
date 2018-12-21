package com.feather.logcontrol.listener;

import android.content.Context;
import android.os.Environment;
import com.feather.logcontrol.Common.Config;

import java.io.*;
import java.util.Date;

/**
 * 姓名：mengc
 * 日期：2018/12/21
 * 功能：
 */

public abstract class LogState implements LogStateListener {
    private String path;
    private Context context;
    private File mFile;
    private String mName;

    public void setPathName(String pathName,Context context) {
        this.path = Config.basePath + pathName + "/";
        this.mName=pathName;
        this.context =context;
        initFile();
    }


    public void appendLog(String content, int level) {
        BufferedWriter out = null;
        try {
            if (mFile == null || !mFile.exists()) {
                return;
            }
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mFile, true),
                    "UTF-8"), 8000);
            StringBuffer sb = new StringBuffer();
            sb.append(Config.SDF2.format(new Date()));
            sb.append("\t ");
            sb.append(level == 1 ? "i" : level == 2 ? "w" : "e");
            sb.append("\t");
            sb.append(content);
            sb.append("\r\n");
            out.write(sb.toString());
        } catch (Exception e) {

        } finally {
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (mFile != null && mFile.length() >= Config.HPNS_LOG_MAX_FILE_SIZE) {
                    initFile();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initFile() {
        try {
            File cacheDir;
            // 如果有SD卡则在SD卡中建一个LazyList的目录存放缓存的图片
            // 没有SD卡就放在系统的缓存目录中
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED))
                cacheDir = new File(
                        path,
                        "nomal_log");
            else
                cacheDir = this.context.getCacheDir();
            if (!cacheDir.exists())
                cacheDir.mkdirs();

            String newLog = mName+".log";
            String bakLog = mName+"-bak.log";
            mFile = new File(cacheDir, newLog);
            if (!mFile.getParentFile().exists()) {
                mFile.getParentFile().mkdirs();
            }
            if (!mFile.exists()) {
                mFile.createNewFile();
            } else if (mFile.length() >= Config.HPNS_LOG_MAX_FILE_SIZE) {
                File file_bak = new File(cacheDir, bakLog);
                if (file_bak.exists())
                    file_bak.delete();
                mFile.renameTo(file_bak);
                mFile = null;
                mFile = new File(cacheDir, newLog);
                mFile.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
