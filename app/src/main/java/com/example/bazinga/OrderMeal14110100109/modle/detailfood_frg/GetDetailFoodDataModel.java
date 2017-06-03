package com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg;

import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.hepler.JsonHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/4/12.
 */

public class GetDetailFoodDataModel implements IgetDetailFoodDataModel {

    private int foodId = Constants.INITCODE;

    private int foodCount = Constants.INITCODE;

    private float price = Constants.INITCODE;

    private int userId = Constants.INITCODE;

    public int getFoodId() {
        return foodId;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public float getPrice() {
        return price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFoodId (int foodId){
        this.foodId = foodId;
    }

    public void setFoodCount(int foodCount){
        this.foodCount = foodCount;
    }

    public void setPrice(float price){
        this.price = price;
    }

    @Override
    public void loadProgress(final GetDetailDataLoadListener getShopDataLoadListener) {

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_GSON,Constants.SERVICE_SHOP,Constants.BaseUrl);

        if (foodId == Constants.INITCODE) {
            getShopDataLoadListener.onCompleted(null);
            return;

        }

        Call<Food> call = retrofirHelper.connectHttp_getFoodInfo(foodId);

        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if(response.isSuccessful()){
                    Food infoBean = response.body();
                    getShopDataLoadListener.onCompleted(infoBean);

                }
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                getShopDataLoadListener.onCompleted(null);
                t.printStackTrace();
            }

        });
    }

    @Override
    public void calculatePrice(GetFoodPrice getFoodPrice) {
        if(price != Constants.INITCODE && foodCount != Constants.INITCODE){
            getFoodPrice.onCompleted(price * foodCount);
        }
    }

    @Override
    public void buyFood(final GetBuyResult getBuyResult) {
        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_Scalars,Constants.SERVICE_PERSONAL,Constants.BaseUrl);

        if (foodId == Constants.INITCODE || userId == Constants.INITCODE ||
                foodCount == Constants.INITCODE || price == Constants.INITCODE) {
            getBuyResult.onCompleted(false);
            return;

        }

        Call<String> call = retrofirHelper.connectHttp_buy(userId,foodId,foodCount,price);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    String infoBean = response.body();
                    JsonHelper jsonHelper = new JsonHelper();
                    String result = jsonHelper.getRusult_Reg(infoBean);

                    if(result != null){
                        if(result.equals(Constants.JSON_RETURN_SUCEESS)){
                            getBuyResult.onCompleted(true);
                        } else{
                            getBuyResult.onCompleted(false);

                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                getBuyResult.onCompleted(false);
                t.printStackTrace();
            }

        });
    }

}
