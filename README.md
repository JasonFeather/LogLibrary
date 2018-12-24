# LogLibraryDemo
**日志收集整理器，传入本地日志名字，自动生成相应的文件夹，日志分为崩溃日志，成常规日志。为了方便日志不占用过大的内存，增加了日志定量删除功能。本项目是专门针对于多项目的应用所设计的。**

## 使用方式
**清单文件配置权限**
...
   <!-- 往SDCard写入数据权限 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <!-- 访问网络，网络定位需要上网 -->
    <uses-permission android:name="android.permission.INTERNET"/>
...

**清单文件配置权限**

        //初始化日志
        LogControl.init(getApplicationContext(),"bbb",true);
        //设置日志本地包大小
        LogControl.setLogSize(10);

**调用**
```Java
        //使用日志  请在项目本地存储后申请否者无效
                LogControl.setLogDate(ErrorLog.class).ShowLogAndWrite("dsjfkls", "skdfjls");
```
