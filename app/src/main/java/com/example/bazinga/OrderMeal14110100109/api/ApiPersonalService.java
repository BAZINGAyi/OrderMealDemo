package com.example.bazinga.OrderMeal14110100109.api;

import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Order;
import com.example.bazinga.OrderMeal14110100109.bean.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bazinga on 2017/3/15.
 */

public interface ApiPersonalService {
    // 评论
    @GET("/social/")
    Observable<List<Comment>> getCommentList(@Query("user_id") int UserId);

    // 订单
    @GET("/getAllUserOrder.do")
    Observable<List<Order>> getOrderList(@Query("user_id") int UserId);

    // 收藏或取消收藏
    @GET("/userCollectShop.do")
    Call<String> setShopCollection(@Query("user_id") int UserId,
                                         @Query("shop_id") int shopId
    );

    // 收藏或取消收藏
    @GET("/userCollectFood.do")
    Call<String> setFoodCollection(@Query("user_id") int UserId,
                               @Query("food_id") int FoodId
    );

    // 判读是否收藏
    @GET("/isCollected.do")
    Call<String> checkCollection(@Query("user_id") int UserId,
                                         @Query("shop_food_id") int shopFoodId,
                                         @Query("flag") int flag
    );

    // 获取用户信息
    @GET("/getUserById.do")
    Observable<UserInfo> getUsInfor(@Query("user_id") int UserId);

    // 修改用户信息
    @GET("/updateUserById.do")
    Observable<UserInfo> setUsInfor(@Query("user_id") int UserId,
                                         @Query("username") String username,
                                         @Query("userpass") String password,
                                         @Query("mobilenum") String mobilenum,
                                         @Query("address") String address
    );

    // 购买接口
    @GET("/insertOrder.do")
    Call<String> buy(@Query("user_id") int userId,
                       @Query("food_id") int foodId,
                       @Query("num") int num,
                       @Query("sum") double sum,
                       @Query("suggesttime") String suggesttime
                       );

}
