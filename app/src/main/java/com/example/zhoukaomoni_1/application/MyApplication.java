package com.example.zhoukaomoni_1.application;

import android.app.Application;
import android.widget.Toast;

import com.example.zhoukaomoni_1.utils.NetWorkUtils;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initNetWork();
    }

    private void initNetWork() {
        boolean b = NetWorkUtils.isNetWorkAvailable(getApplicationContext());
        if(b){//网络正常
            Toast.makeText(getApplicationContext(),"网络正常",Toast.LENGTH_LONG).show();
        }else{
            //网络异常
            Toast.makeText(getApplicationContext(),"网络异常",Toast.LENGTH_LONG).show();
        }
    }

}
