package com.example.bazinga.OrderMeal14110100109.presenter.frag;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.modle.activity.GetShopDeatilDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.activity.IgetShopDeatilDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.GetDetailFoodDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.IgetDetailFoodDataModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowFoodDetailView;

import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public class GetFoodDetailDataPersenter extends BasePresenter<IShowFoodDetailView> {


    GetDetailFoodDataModel getDetailFoodDataModel = new GetDetailFoodDataModel();

    public void getFoodData(int foodId){

        if (getDetailFoodDataModel != null){
            getDetailFoodDataModel.setFoodId(foodId);
            getDetailFoodDataModel.loadProgress(new IgetDetailFoodDataModel.GetDetailDataLoadListener() {
                @Override
                public void onCompleted(Food datas) {

                    if(datas != null){
                        presenterView.showShowData(datas);
                    }else{
                        presenterView.showError(String.valueOf(R.string.networkError));
                    }

                }
            });
        }
    }

    public void getFoodPrice(int foodCount){

        if(getDetailFoodDataModel != null){
            getDetailFoodDataModel.setFoodCount(foodCount);
            getDetailFoodDataModel.calculatePrice(new IgetDetailFoodDataModel.GetFoodPrice() {
                @Override
                public void onCompleted(float price) {
                    if (price != Constants.INITCODE){
                        presenterView.showPrice(price);
                    }
                }
            });
        }

    }

    public void setPrice(float price){
            getDetailFoodDataModel.setPrice(price);
    }

    public void buyFood(int userId, int foodId, final int foodCount, float foodPrice) {
        if(getDetailFoodDataModel != null){
            getDetailFoodDataModel.setPrice(foodPrice);
            getDetailFoodDataModel.setFoodCount(foodCount);
            getDetailFoodDataModel.setFoodId(foodId);
            getDetailFoodDataModel.setUserId(userId);

            getDetailFoodDataModel.buyFood(new IgetDetailFoodDataModel.GetBuyResult() {
                @Override
                public void onCompleted(boolean result) {
                    if (result == true){
                        presenterView.showBuy(true);
                    }else{
                        presenterView.showBuy(false);
                    }
                }
            });
        }
    }
}
