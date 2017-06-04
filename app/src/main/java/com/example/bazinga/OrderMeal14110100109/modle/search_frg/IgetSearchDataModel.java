package com.example.bazinga.OrderMeal14110100109.modle.search_frg;

import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;

import java.util.List;

/**
 * Created by bazinga on 2017/4/12.
 */

public interface IgetSearchDataModel {

    void loadProgress(GetSearchDataLoadListener getShopDataLoadListener);

    interface GetSearchDataLoadListener{
        void onCompleted(List<SearchFood> datas);
    }
}
