package com.example.bazinga.OrderMeal14110100109.presenter.reg_login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.hepler.SecurityClass;
import com.example.bazinga.OrderMeal14110100109.modle.reg_login.CheckUserLoginModel;
import com.example.bazinga.OrderMeal14110100109.modle.reg_login.ICheckUserModel;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCheckResultView;


public class CheckUserLoginPersenter extends BasePresenter<IShowCheckResultView> {

    CheckUserLoginModel checkUserLoginModel = new CheckUserLoginModel();

    public CheckUserLoginPersenter(){}

    public void check(final String name, final String password,final Boolean isRememberPass){

        if(name == null || "".equals(name) || password == null || "".equals(name))
            presenterView.showCheckResult(false);

        if(checkUserLoginModel != null){
            checkUserLoginModel.setUserInfo(name,password);
            checkUserLoginModel.loadProgress(new ICheckUserModel.CheckUserLoadListener() {
                @Override
                public void onCompleted(Boolean isTrue,String userId) {
                    if (isTrue){
                            saveUserInfo(name,password,isRememberPass,userId);
                        presenterView.showCheckResult(true);
                    } else{
                        presenterView.showCheckResult(false);

                    }
                }
            });
        }
    }

    private void saveUserInfo(String name , String password,Boolean isRememberPass,String userId) {
         SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!isRememberPass){
            editor.remove(context.getString(R.string.username));
            editor.remove(context.getString(R.string.password));
            editor.apply();
        }else{
            SecurityClass s = new SecurityClass();
            String newPass = s.getMD5(password);
            editor.putString(context.getString(R.string.username),name);
            editor.putString(context.getString(R.string.password), newPass);
            editor.putString(context.getString(R.string.userId), userId);
            editor.apply();

        }

    }

}
