package com.example.bazinga.OrderMeal14110100109.modle.activity;

import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.commoninterface.CollectInterface;
import com.example.bazinga.OrderMeal14110100109.hepler.JsonHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/5/8.
 */

public class FoodDetailActivityModel implements IFoodDeatilActivityModel {

    private int foodId  = Constants.INITCODE ;
    private int userId = Constants.INITCODE;

    public  void setfoodId( int shopId){
        this.foodId = shopId;
    }
    public  void setUserId( int userId){
        this.userId = userId;
    }


    @Override
    public void collectFood(final CollectInterface collectInterface) {

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_Scalars,Constants.SERVICE_PERSONAL,Constants.BaseUrl);

        if (foodId == Constants.INITCODE || userId == Constants.INITCODE) {
            collectInterface.collectCompleted(false);
            return;
        }

        Call<String> call = retrofirHelper.connectHttp_collectFood(userId,foodId);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String infoBean = response.body();
                    JsonHelper jsonHelper = new JsonHelper();
                    String result = jsonHelper.tranfromJsonToString(infoBean,Constants.JSON_RETURN_CONNECTION_SUCCESS);

                    if(result != null){
                        if(result.equals(Constants.JSON_RETURN_SUCEESS)){
                            collectInterface.collectCompleted(true);
                        } else{
                            collectInterface.collectCompleted(false);

                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                collectInterface.collectCompleted(false);
                t.printStackTrace();
            }

        });
    }

    public void checkCollectShop(final CollectInterface collectInterface) {
        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_Scalars,Constants.SERVICE_PERSONAL,Constants.BaseUrl);

        if (foodId == Constants.INITCODE || userId == Constants.INITCODE) {
            collectInterface.collectCheck(false);
            return;
        }

        Call<String> call = retrofirHelper.connectHttp_collectCheck(userId,foodId,Constants.COLLECT_FOOD_FLAG);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String infoBean = response.body();
                    JsonHelper jsonHelper = new JsonHelper();
                    String result = jsonHelper.tranfromJsonToString(infoBean,Constants.JSON_RETURN_CONNECTION);

                    if(result != null){
                        if(result.equals(Constants.JSON_RETURN_SUCEESS)){
                            collectInterface.collectCheck(true);
                        } else{
                            collectInterface.collectCheck(false);

                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                collectInterface.collectCompleted(false);
                t.printStackTrace();
            }

        });
    }
}
