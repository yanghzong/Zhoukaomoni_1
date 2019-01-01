package com.example.zhoukaomoni_1.presenter;

import com.example.zhoukaomoni_1.bean.ShopBean;
import com.example.zhoukaomoni_1.inter.ICallBack;
import com.example.zhoukaomoni_1.model.ShopModel;
import com.example.zhoukaomoni_1.view.ShopView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ShopPresenter {
    private ShopModel shopModel;
    private ShopView shopView;
    public void attach(ShopView shopView){
        this.shopView = shopView;
        shopModel = new ShopModel();
    }
    //商品请求方法
    public void getShop(String url){
        Type type = new TypeToken<ShopBean>(){}.getType();
        //通过M调用网络请求方法
        shopModel.getShop(url, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                shopView.getShop((ShopBean) obj);

            }

            @Override
            public void onFailed(Exception e) {
                shopView.failed(e);

            }
        },type);

    }



    //解耦
    public void datach(){
        if(shopView!=null){
            shopModel = null;
        }
    }

}
