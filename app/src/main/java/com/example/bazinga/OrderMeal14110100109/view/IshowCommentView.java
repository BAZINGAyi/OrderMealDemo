package com.example.bazinga.OrderMeal14110100109.view;

import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;

import java.util.List;

/**
 * Created by bazinga on 2017/5/8.
 */

public interface IShowCommentView {

    void showShowData(List<Comment> comments);

    void showError(String msg);
}
