package com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg;

import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;

import java.util.List;

/**
 * Created by bazinga on 2017/4/12.
 */

public interface IgetCommentDataModel {

    interface GetDetailCommentListener{
        void onCompleted(List<Comment> datas);
    }

    void loadComment(GetDetailCommentListener getDetailCommentListener);
}
