package com.example.zhoukaomoni_1.presenter;

import com.example.zhoukaomoni_1.bean.DataShopBean;
import com.example.zhoukaomoni_1.inter.ICallBack;
import com.example.zhoukaomoni_1.model.ShopModel;
import com.example.zhoukaomoni_1.view.DataView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DataShopPresenter {
    private ShopModel shopModel;
    private DataView dataView;


    public  void  attach(DataView dataView){
        this.dataView=dataView;
        shopModel=new ShopModel();
    }


    public  void  DataShop(String  url){
        Type type=new TypeToken<DataShopBean>(){}.getType();
        shopModel.getShop(url, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                dataView.getData((DataShopBean) obj);
            }

            @Override
            public void onFailed(Exception e) {
            }


        },type);
    }

    public  void  detach(){
        if (shopModel!=null){
            shopModel=null;
        }
        if (dataView!=null){
            dataView=null;
        }
    }
}
