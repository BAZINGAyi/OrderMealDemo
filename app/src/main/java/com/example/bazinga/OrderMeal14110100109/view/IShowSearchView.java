package com.example.bazinga.OrderMeal14110100109.view;

import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;

import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public interface IShowSearchView {

    void showShowData(List<SearchFood> searchFoods);

    void showError(String msg);
}
