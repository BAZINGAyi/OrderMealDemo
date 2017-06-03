package com.example.bazinga.OrderMeal14110100109.modle.activity;

import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.commoninterface.CollectInterface;

import java.util.List;

/**
 * Created by bazinga on 2017/4/12.
 */

public interface IgetShopDeatilDataModel {

    void loadProgress(GetShopDeatilDataLoadListener getShopDataLoadListener);

    interface GetShopDeatilDataLoadListener{
        void onCompleted(List<ShopFood> datas);
    }

    void collectShop(CollectInterface collectInterface);
}
