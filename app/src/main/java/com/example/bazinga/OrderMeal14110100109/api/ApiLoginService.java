package com.example.bazinga.OrderMeal14110100109.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bazinga on 2017/4/10.
 */

public interface   ApiLoginService {

    // 登录
    @GET("/foodService/userLogin.do")
    Call<String> login(@Query("username") String username,
                       @Query("userpass") String password);

    // 注册
    @GET("foodService/userRegister.do")
    Call<String> Register(@Query("username") String username,
                       @Query("userpass") String password,
                       @Query("mobilenum") String mobilenum,
                       @Query("address") String address
                       );
}
