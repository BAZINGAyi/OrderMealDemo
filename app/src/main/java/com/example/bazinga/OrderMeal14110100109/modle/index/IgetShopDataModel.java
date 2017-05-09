package com.example.bazinga.OrderMeal14110100109.modle.index;

import com.example.bazinga.OrderMeal14110100109.bean.Shop;

import java.util.List;

/**
 * Created by bazinga on 2017/4/12.
 */

public interface IgetShopDataModel {

    void loadProgress(GetShopDataLoadListener getShopDataLoadListener);

    interface GetShopDataLoadListener{
        void onCompleted(List<Shop> datas);
    }
}
