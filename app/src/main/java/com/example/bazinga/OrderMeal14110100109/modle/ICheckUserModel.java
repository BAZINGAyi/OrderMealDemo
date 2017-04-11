package com.example.bazinga.OrderMeal14110100109.modle;

/**
 * Created by bazinga on 2017/4/11.
 */

import java.util.List;

/**
 * 用于处理登录注册等的逻辑
 */
public interface ICheckUserModel {

    void loadProgress(CheckUserLoadListener checkUserLoadListener);

    // 回调的接口

    interface CheckUserLoadListener{
        void onCompleted(Boolean isTrue);
    }

}
