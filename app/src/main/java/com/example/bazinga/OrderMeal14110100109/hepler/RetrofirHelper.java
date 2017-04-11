package com.example.bazinga.OrderMeal14110100109.hepler;

import com.example.bazinga.OrderMeal14110100109.api.ApiLoginService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by bazinga on 2017/4/11.
 */

public class RetrofirHelper {

    Retrofit retrofit;

    ApiLoginService infoApi;

    public void HelpRetrofit_Scalars(String url){
        retrofit = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url).build();
        //创建api访问请求
        infoApi = retrofit.create(ApiLoginService.class);
    }


    public Call<String> connectHttp(String name, String pass){
        Call<String> call = infoApi.login(name,pass);
        return call;
    }
}
