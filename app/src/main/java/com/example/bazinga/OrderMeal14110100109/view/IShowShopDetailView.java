package com.example.bazinga.OrderMeal14110100109.view;

import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;

import java.util.List;

/**
 * Created by bazinga on 2017/5/8.
 */

public interface IShowShopDetailView {

    void showShowData(List<ShopFood> shopList);

    void showError(String msg);

    void showCollectResult(Boolean result);

    void showCheckCollectResult(Boolean result);
}
