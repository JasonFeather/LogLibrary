package com.loglibrary.wing.log;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.feather.LogControl;
import com.feather.State.ErrorLog;
import com.feather.State.InfoLog;
import com.feather.State.VerboseLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] permissions =new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this,permissions, 1);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用日志  请在项目本地存储后申请否者无效
                LogControl.setLogDate(ErrorLog.class).ShowLogAndWrite("dsjfkls", "skdfjls");
                LogControl.setLogDate(InfoLog.class).ShowLogAndWrite("aaa", "aaaa");
                LogControl.setLogDate(VerboseLog.class).ShowLogAndWrite("bbbb", "aaaa");
            }
        });
    }
}
