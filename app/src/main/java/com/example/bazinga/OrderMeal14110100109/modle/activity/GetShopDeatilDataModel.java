package com.example.bazinga.OrderMeal14110100109.modle.activity;

import com.example.bazinga.OrderMeal14110100109.adapter.ShopDetailAdapter;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;
import com.example.bazinga.OrderMeal14110100109.ui.ShopDetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/5/8.
 */

public class GetShopDeatilDataModel implements IgetShopDeatilDataModel {

    private int shopId  = -1 ;

    public   void setShopId( int shopId){
        this.shopId = shopId;
    }

    @Override
    public void loadProgress(final GetShopDeatilDataLoadListener getShopDataLoadListener) {

        RetrofirHelper retrofirHelper = new RetrofirHelper();

        retrofirHelper.HelpRetrofit_Gson(Constants.BaseUrl);

        if (shopId == -1)

            return;

        Call<List<ShopFood>> call = retrofirHelper.connectHttp_getShopDetailData(shopId);

        call.enqueue(new Callback<List<ShopFood>>() {
            @Override
            public void onResponse(Call<List<ShopFood>> call, Response<List<ShopFood>> response) {

                if(response.isSuccessful()){

                    List<ShopFood> infoBean = response.body();

                    getShopDataLoadListener.onCompleted(infoBean);

                }
            }

            @Override
            public void onFailure(Call<List<ShopFood>> call, Throwable t) {

                t.printStackTrace();
            }

        });


    }
}
