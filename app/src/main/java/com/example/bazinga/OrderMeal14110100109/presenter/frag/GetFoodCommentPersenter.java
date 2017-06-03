package com.example.bazinga.OrderMeal14110100109.presenter.frag;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.GetCommentDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.GetDetailFoodDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.IgetCommentDataModel;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.IgetDetailFoodDataModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCommentView;


import java.util.List;

/**
 * Created by bazinga on 2017/4/17.
 */

public class GetFoodCommentPersenter extends BasePresenter<IShowCommentView> {


    GetCommentDataModel getCommentDataModel = new GetCommentDataModel();

    public void getCommentData(int foodId){

        if (getCommentDataModel != null){

            getCommentDataModel.setFoodId(foodId);

            getCommentDataModel.loadComment(new IgetCommentDataModel.GetDetailCommentListener(){
                @Override
                public void onCompleted(List<Comment> datas) {
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
