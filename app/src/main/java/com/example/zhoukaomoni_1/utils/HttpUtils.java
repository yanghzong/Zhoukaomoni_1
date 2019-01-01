package com.example.zhoukaomoni_1.utils;

import android.os.Handler;

import com.example.zhoukaomoni_1.inter.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {

    private static  volatile  HttpUtils  instance;
    private OkHttpClient client;
    private Handler handler=new Handler();

    public  HttpUtils(){
        client=new OkHttpClient();

    }
    public static HttpUtils getInstance(){
        if(instance==null){
            synchronized (HttpUtils.class){
                if(null == instance){
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    //创建请求数据方法
    public void getData(String url, final ICallBack callBack, final Type type){

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                //失败时
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                //成功
                //得到数据
                String result = response.body().string();
                //使用gson解析
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(o);
                    }
                });
            }
        });
    }


}
