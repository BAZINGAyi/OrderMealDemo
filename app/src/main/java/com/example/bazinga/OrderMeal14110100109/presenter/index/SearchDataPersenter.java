package com.example.bazinga.OrderMeal14110100109.presenter.index;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.modle.index.GetShopDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.index.IgetShopDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.search_frg.GetSearchDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.search_frg.IgetSearchDataModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowIndexView;
import com.example.bazinga.OrderMeal14110100109.view.IShowSearchView;

import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public class SearchDataPersenter extends BasePresenter<IShowSearchView> {

    GetSearchDataModel igetSearchDataModel = new GetSearchDataModel();

    public void getSearchData(){
        if (igetSearchDataModel != null){
            igetSearchDataModel.loadProgress(new IgetSearchDataModel.GetSearchDataLoadListener() {
                @Override
                public void onCompleted(List<SearchFood> datas) {
                    if(datas != null){
                        presenterView.showShowData(datas);
                    }else{
                        presenterView.showError(String.valueOf(R.string.networkError));
                    }
                }
            });
        }
    }

    public void setSearchContent (String content){
        if(igetSearchDataModel != null){
            igetSearchDataModel.setSearchContent(content);
        }
    }

}
