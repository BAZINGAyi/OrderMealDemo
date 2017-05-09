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

    IShowCheckResultView iShowCheckResultView;

    CheckUserRegisterModel checkUserRegisterModel= new CheckUserRegisterModel();

    Context context ;

    public void setMyContext( Context context ){

        this.context = context;
    }

    public void attach(IShowCheckResultView iShowCheckResultView){
        this.iShowCheckResultView = iShowCheckResultView;
    }

    public void register( Map<String,String> maps){

        if(checkUserRegisterModel != null){

            checkUserRegisterModel.setUserInfo(maps,context);

            checkUserRegisterModel.loadProgress(new ICheckUserModel.CheckUserLoadListener() {
                @Override
                public void onCompleted(Boolean isTrue) {
                    if (isTrue){

                        iShowCheckResultView.showCheckResult(true);

                    } else
                    iShowCheckResultView.showCheckResult(false);
                }
            });

        }
    }
}
