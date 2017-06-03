package com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg;

import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.view.IShowShopDetailView;

import java.util.List;

/**
 * Created by bazinga on 2017/4/12.
 */

public interface IgetDetailFoodDataModel {

    // 加载食物信息
    void loadProgress(GetDetailDataLoadListener getShopDataLoadListener);
    interface GetDetailDataLoadListener{
        void onCompleted(Food datas);
    }

    // 计算商品价格
    void calculatePrice(GetFoodPrice getFoodPrice);
    interface GetFoodPrice{
        void onCompleted(float price);
    }

    // 购买商品
    void buyFood(GetBuyResult getBuyResult);
    interface GetBuyResult{
        void onCompleted(boolean result);
    }
}
