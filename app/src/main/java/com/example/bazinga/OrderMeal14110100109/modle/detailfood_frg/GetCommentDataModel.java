package com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg;

import android.util.Log;

import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/4/12.
 */

public class GetCommentDataModel implements IgetCommentDataModel {

    private int foodId = Constants.INITCODE;

    public void setFoodId (int foodId){
        this.foodId = foodId;
    }

    @Override
    public void loadComment(final GetDetailCommentListener getDetailCommentListener) {

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_GSON,Constants.SERVICE_SHOP,Constants.BaseUrl);

        if (foodId == Constants.INITCODE){
            getDetailCommentListener.onCompleted(null);
            return;
        }


        Call< List<Comment>> call = retrofirHelper.connectHttp_getComment(foodId);

        call.enqueue(new Callback< List<Comment>>() {
            @Override
            public void onResponse(Call< List<Comment>> call, Response< List<Comment>> response) {

                if(response.isSuccessful()){
                    List<Comment> infoBean = response.body();
                    getDetailCommentListener.onCompleted(infoBean);

                }
            }

            @Override
            public void onFailure(Call< List<Comment>> call, Throwable t) {
                getDetailCommentListener.onCompleted(null);
                Log.e("GetCommentDataModel", "onFailure: network");
                t.printStackTrace();
            }

        });
    }
}
