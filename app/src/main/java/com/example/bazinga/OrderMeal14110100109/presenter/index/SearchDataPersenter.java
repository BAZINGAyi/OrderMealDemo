package com.example.bazinga.OrderMeal14110100109.presenter.index;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.modle.index.GetShopDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.index.IgetShopDataModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowIndexView;

import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public class SearchDataPersenter extends BasePresenter<IShowIndexView> {

    GetShopDataModel getShopDataModel = new GetShopDataModel();

    public void getShopData(){
        if (getShopDataModel != null){
            getShopDataModel.loadProgress(new IgetShopDataModel.GetShopDataLoadListener() {
                @Override
                public void onCompleted(List<Shop> datas) {
                    if(datas != null){
                        presenterView.showShowData(datas);
                    }else{
                        presenterView.showError(String.valueOf(R.string.networkError));
                    }
                }
            });
        }
    }

}
