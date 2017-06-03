package com.example.bazinga.OrderMeal14110100109.presenter.activity;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.commoninterface.CollectInterface;
import com.example.bazinga.OrderMeal14110100109.modle.activity.GetShopDeatilDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.activity.IgetShopDeatilDataModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowShopDetailView;


import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public class GetShopDetailDataPersenter extends BasePresenter<IShowShopDetailView> {


    GetShopDeatilDataModel getShopDeatilDataModel = new GetShopDeatilDataModel();

    public void getShopData(int shopId){

        if (getShopDeatilDataModel != null){
            getShopDeatilDataModel.setShopId(shopId);
            getShopDeatilDataModel.loadProgress(new IgetShopDeatilDataModel.GetShopDeatilDataLoadListener() {
                @Override
                public void onCompleted(List<ShopFood> datas) {

                    if(datas != null){
                        presenterView.showShowData(datas);
                    }else{
                        presenterView.showError(String.valueOf(R.string.networkError));
                    }

                }
            });
        }
    }

    public void collectShop(int userId, int shopId) {
        if(getShopDeatilDataModel != null){
            getShopDeatilDataModel.setShopId(shopId);
            getShopDeatilDataModel.setUserId(userId);
            getShopDeatilDataModel.collectShop(new CollectInterface() {
                @Override
                public void collectCompleted(Boolean result) {
                    if(result != null){
                        presenterView.showCollectResult(result);
                    }
                }

                @Override
                public void collectCheck(Boolean result) {

                }
            });
        }
    }

    public void checkUserCollection(int userId, int shopId) {
        if(getShopDeatilDataModel != null){
            getShopDeatilDataModel.setShopId(shopId);
            getShopDeatilDataModel.setUserId(userId);
            getShopDeatilDataModel.checkCollectShop(new CollectInterface() {
                @Override
                public void collectCompleted(Boolean result) {
                }

                @Override
                public void collectCheck(Boolean result) {
                    if(result != null){
                        presenterView.showCheckCollectResult(result);
                    }
                }
            });
        }
    }
}
