package com.example.bazinga.OrderMeal14110100109.hepler;

import com.example.bazinga.OrderMeal14110100109.api.ApiLoginService;
import com.example.bazinga.OrderMeal14110100109.api.ApiShopService;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by bazinga on 2017/4/11.
 */

public class RetrofirHelper {

    Retrofit retrofit;

    ApiLoginService infoApi;

    ApiShopService infoShopApi;

    public void HelpRetrofit_Scalars(String url){
        retrofit = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url).build();
        //创建api访问请求
        infoApi = retrofit.create(ApiLoginService.class);
    }

    public void HelpRetrofit_Gson(String url){
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url).build();
        //创建api访问请求
        infoShopApi = retrofit.create(ApiShopService.class);
    }

    public Call<List<Shop>> connectHttp_getData(){
        Call<List<Shop>> call = infoShopApi.getShopList();
        return call;
    }

    public Call<List<ShopFood>> connectHttp_getShopDetailData(int shopId){
        Call<List<ShopFood>> call = infoShopApi.getShopFoodList(shopId);
        return call;
    }


    public Call<String> connectHttp(String name, String pass){
        Call<String> call = infoApi.login(name,pass);
        return call;
    }

    public Call<String> connectHttp_reg(String name, String pass,String mobilenum,String address,
                                        String comment){
        Call<String> call = infoApi.Register(name,pass,mobilenum,address,comment);
        return call;
    }
}
