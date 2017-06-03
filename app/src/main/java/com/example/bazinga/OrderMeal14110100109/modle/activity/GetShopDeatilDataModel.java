package com.example.bazinga.OrderMeal14110100109.modle.activity;

import com.example.bazinga.OrderMeal14110100109.adapter.ShopDetailAdapter;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.commoninterface.CollectInterface;
import com.example.bazinga.OrderMeal14110100109.hepler.JsonHelper;
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

    private int shopId  = Constants.INITCODE ;
    private int userId = Constants.INITCODE;

    public  void setShopId( int shopId){
        this.shopId = shopId;
    }
    public  void setUserId( int userId){
        this.userId = userId;
    }

    @Override
    public void loadProgress(final GetShopDeatilDataLoadListener getShopDataLoadListener) {

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_GSON,Constants.SERVICE_SHOP,Constants.BaseUrl);
        if (shopId == Constants.INITCODE)
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

    @Override
    public void collectShop(final CollectInterface collectInterface) {

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_Scalars,Constants.SERVICE_PERSONAL,Constants.BaseUrl);

        if (shopId == Constants.INITCODE || userId == Constants.INITCODE) {
            collectInterface.collectCompleted(false);
            return;
        }

        Call<String> call = retrofirHelper.connectHttp_collectShop(userId,shopId);
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

        if (shopId == Constants.INITCODE || userId == Constants.INITCODE) {
            collectInterface.collectCheck(false);
            return;
        }

        Call<String> call = retrofirHelper.connectHttp_collectCheck(userId,shopId,Constants.COLLECT_SHOP_FLAG);
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
