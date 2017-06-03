package com.example.bazinga.OrderMeal14110100109.api;

import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bazinga on 2017/3/15.
 */

public interface ApiShopService {

    // 获取所有店铺

    @GET("/getAllShops.do")
    Call<List<Shop>> getShopList();

    // 获取店铺的所有菜谱

    @GET("/getFoodByShop.do")
    Call<List<ShopFood>> getShopFoodList(@Query("shop_id") int shopId);

    // 获取每道菜的详细信息
    @GET("/getFoodById.do")
    Call<Food> getFood(@Query("food_id") int foodId);

    // 获取每道菜的评论
    @GET("/getAllUserComment.do")
    Call<List<Comment>> getComment(@Query("user_id") int foodId);

    // 搜索菜谱
    @GET("/getFoodBySearch.do ")
    Call<List<SearchFood>> getSearchFoodList(@Query("search")String food);
}
