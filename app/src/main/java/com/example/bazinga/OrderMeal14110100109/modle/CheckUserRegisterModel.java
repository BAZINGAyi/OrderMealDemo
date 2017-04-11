package com.example.bazinga.OrderMeal14110100109.modle;

/**
 * Created by bazinga on 2017/4/11.
 */

public class CheckUserRegisterModel implements ICheckUserModel {



    @Override
    public void loadProgress(CheckUserLoadListener checkUserLoadListener) {
        // 加载网络数据
        checkUserLoadListener.onCompleted(true);
    }





}
