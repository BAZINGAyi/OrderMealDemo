package com.example.bazinga.OrderMeal14110100109.modle.index;

import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/4/12.
 */

public class GetShopDataModel implements IgetShopDataModel {
    @Override
    public void loadProgress(final GetShopDataLoadListener getShopDataLoadListener) {

        RetrofirHelper retrofirHelper = new RetrofirHelper();

        retrofirHelper.HelpRetrofit_Gson(Constants.BaseUrl);

        Call<List<Shop>> call = retrofirHelper.connectHttp_getData();

        call.enqueue(new Callback<List<Shop>>() {
            @Override
            public void onResponse(Call<List<Shop>> call, Response<List<Shop>> response) {

                if(response.isSuccessful()){

                    List<Shop> infoBean = response.body();

                    getShopDataLoadListener.onCompleted(infoBean);

                    }
                }

            @Override
            public void onFailure(Call<List<Shop>> call, Throwable t) {

                t.printStackTrace();
            }

        });
    }
}
