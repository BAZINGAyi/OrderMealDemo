package com.example.bazinga.OrderMeal14110100109.presenter;

import com.bumptech.glide.util.Util;
import com.example.bazinga.OrderMeal14110100109.modle.CheckUserLoginModel;
import com.example.bazinga.OrderMeal14110100109.modle.ICheckUserModel;
import com.example.bazinga.OrderMeal14110100109.view.IShowCheckResultView;

/**
 * Created by bazinga on 2017/4/11.
 */

public class CheckUserLoginPersenter extends BasePresenter<IShowCheckResultView> {

    IShowCheckResultView iShowCheckResultView;

    CheckUserLoginModel checkUserLoginModel = new CheckUserLoginModel();

    public CheckUserLoginPersenter(){}

    public void attach(IShowCheckResultView iShowCheckResultView){
        this.iShowCheckResultView = iShowCheckResultView;
    }


    public void check(String name,String password){

        if(name == null || "".equals(name) || password == null || "".equals(name))

            iShowCheckResultView.showCheckResult(false);

        if(checkUserLoginModel != null){

            checkUserLoginModel.setUserInfo(name,password);

            checkUserLoginModel.loadProgress(new ICheckUserModel.CheckUserLoadListener() {
                @Override
                public void onCompleted(Boolean isTrue) {
                    if (isTrue)

                        iShowCheckResultView.showCheckResult(true);

                    else

                        iShowCheckResultView.showCheckResult(false);
                }
            });
        }
    }
}
