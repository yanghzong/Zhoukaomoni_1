package com.example.zhoukaomoni_1.view;

import com.example.zhoukaomoni_1.bean.ShopBean;

public interface ShopView {
    void  getShop(ShopBean shopBean);
    void  failed(Exception e);
}
