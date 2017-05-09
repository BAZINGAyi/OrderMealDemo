package com.example.bazinga.OrderMeal14110100109.presenter.activity;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.modle.activity.GetShopDeatilDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.activity.IgetShopDeatilDataModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IshowShopDetailView;

import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public class GetShopDetailDataPersenter extends BasePresenter<IshowShopDetailView> {

    IshowShopDetailView ishowShopDetailView;

    GetShopDeatilDataModel getShopDeatilDataModel = new GetShopDeatilDataModel();

    public void attach(IshowShopDetailView ishowShopDetailView){
        this.ishowShopDetailView = ishowShopDetailView;
    }

    public void getShopData(int shopId){

        if (getShopDeatilDataModel != null && shopId != -1){

            getShopDeatilDataModel.setShopId(shopId);

            getShopDeatilDataModel.loadProgress(new IgetShopDeatilDataModel.GetShopDeatilDataLoadListener() {
                @Override
                public void onCompleted(List<ShopFood> datas) {

                    if(datas != null){
                        ishowShopDetailView.showShowData(datas);
                    }else{
                        ishowShopDetailView.showError(String.valueOf(R.string.networkError));
                    }

                }
            });
        }
    }

}
