package com.example.zhoukaomoni_1.model;

import com.example.zhoukaomoni_1.inter.ICallBack;
import com.example.zhoukaomoni_1.utils.HttpUtils;

import java.lang.reflect.Type;

public class ShopModel {
    //商品请求数据方法
    public void getShop(String url, ICallBack callBack, Type type){
        //调用网络请求
        HttpUtils.getInstance().getData(url,callBack,type);
    }
}
