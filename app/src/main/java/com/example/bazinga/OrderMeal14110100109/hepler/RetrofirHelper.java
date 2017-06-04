package com.example.bazinga.OrderMeal14110100109.hepler;

import android.util.Log;

import com.example.bazinga.OrderMeal14110100109.api.ApiLoginService;
import com.example.bazinga.OrderMeal14110100109.api.ApiPersonalService;
import com.example.bazinga.OrderMeal14110100109.api.ApiShopService;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;

import java.util.List;
import java.util.Map;

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

    ApiPersonalService apiPersonalService;

    Map<String,String> extraData ;

    public static RetrofirHelper retrofirHelper ;

    private RetrofirHelper(){};

    public static RetrofirHelper getIntents(){

        if(retrofirHelper == null) {
            retrofirHelper = new RetrofirHelper();
        }

        return retrofirHelper;
    }

    public void start_RetrofirHelper(int dataType , int className, String url){

        // 连接类型
        if(dataType == Constants.DATATYPE_Scalars){
            retrofit = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
                    .baseUrl(url).build();
        }else{
            retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url).build();
        }

        // 连接类的类型
        if(className == Constants.SERVICE_LOGIN){
            infoApi = retrofit.create(ApiLoginService.class);
        }else if(className == Constants.SERVICE_SHOP){
            infoShopApi = retrofit.create(ApiShopService.class);
        }else {
            apiPersonalService = retrofit.create(ApiPersonalService.class);
        }

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

    public Call<Food> connectHttp_getFoodInfo(int foodId){
        Call<Food> call = infoShopApi.getFood(foodId);
        return call;
    }

    public Call<List<Comment>> connectHttp_getComment(int foodId){
        Call<List<Comment>> call = infoShopApi.getComment(foodId);
        return call;
    }

    public Call<String> connectHttp_buy(int userId,int foodId,int num,float sum){
        Call<String> call = apiPersonalService.buy(userId,foodId,num,sum,null);
        return call;
    }

    public Call<String> connectHttp_collectShop(int userId, int shopId){
        Call<String> call = apiPersonalService.setShopCollection(userId,shopId);
        return call;
    }

    public Call<String> connectHttp_collectFood(int userId, int foodId){
        Call<String> call = apiPersonalService.setFoodCollection(userId,foodId);
        return call;
    }

    public Call<String> connectHttp_collectCheck(int userId, int shopId,int shopFlag){
        Call<String> call = apiPersonalService.checkCollection(userId,shopId,shopFlag);
        return call;
    }

    public Call<List<SearchFood>> connectHttp_getSearchFoodList(String foodName){
        Call<List<SearchFood>> call = infoShopApi.getSearchFoodList(foodName);
        return call;
    }

}
