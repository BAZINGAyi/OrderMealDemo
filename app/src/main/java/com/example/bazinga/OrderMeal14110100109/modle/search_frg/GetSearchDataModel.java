package com.example.bazinga.OrderMeal14110100109.modle.search_frg;

import android.view.View;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.hepler.RandomDataHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;
import com.example.bazinga.OrderMeal14110100109.modle.index.IgetShopDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/4/12.
 */

public class GetSearchDataModel implements IgetSearchDataModel {

    private String searchContent = null ;

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    @Override

    public void loadProgress(final GetSearchDataLoadListener getSearchDataLoadListener) {

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_GSON, Constants.SERVICE_SHOP, Constants.BaseUrl);

        if(searchContent == null){
            getSearchDataLoadListener.onCompleted(null);
        }

        Call<List<SearchFood>> call = retrofirHelper.connectHttp_getSearchFoodList(searchContent);
        call.enqueue(new Callback<List<SearchFood>>() {
            @Override
            public void onResponse(Call<List<SearchFood>> call, Response<List<SearchFood>> response) {
                if (response.isSuccessful()) {
                    List<SearchFood> infoBean = response.body();
                    getSearchDataLoadListener.onCompleted(infoBean);
                }
            }

            @Override
            public void onFailure(Call<List<SearchFood>> call, Throwable t) {
                getSearchDataLoadListener.onCompleted(null);
                t.printStackTrace();
            }

        });
    }


}
