package com.example.bazinga.OrderMeal14110100109.presenter.reg_login;

import android.content.Context;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.modle.reg_login.CheckUserRegisterModel;
import com.example.bazinga.OrderMeal14110100109.modle.reg_login.ICheckUserModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCheckResultView;

import java.util.HashMap;
import java.util.Map;

public class CheckUserRegisterPresenter extends BasePresenter<IShowCheckResultView> {

    CheckUserRegisterModel checkUserRegisterModel= new CheckUserRegisterModel();

    public void register( Map<String,String> maps){

        if(checkUserRegisterModel != null){

            checkUserRegisterModel.setUserInfo(maps,context);

            checkUserRegisterModel.loadProgress(new ICheckUserModel.CheckUserLoadListener() {
                @Override
                public void onCompleted(Boolean isTrue,String userId) {
                    if (isTrue){

                        presenterView.showCheckResult(true);

                    } else
                        presenterView.showCheckResult(false);
                }
            });

        }
    }
}
