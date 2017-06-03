package com.example.bazinga.OrderMeal14110100109.view;

import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;

import java.util.List;

/**
 * Created by bazinga on 2017/5/8.
 */

public interface IShowFoodDetailView {

    void showShowData(Food food);

    void showError(String msg);

    void showPrice(float price);

    void showBuy(Boolean result);
}
