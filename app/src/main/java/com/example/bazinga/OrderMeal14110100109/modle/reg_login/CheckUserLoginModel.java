package com.example.bazinga.OrderMeal14110100109.modle.reg_login;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.hepler.JsonHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/4/11.
 */

public class CheckUserLoginModel implements ICheckUserModel {

    String name ;

    String password;

    @Override
    public void loadProgress(final CheckUserLoadListener checkUserLoadListener) {

        RetrofirHelper retrofirHelper = new RetrofirHelper();

        retrofirHelper.HelpRetrofit_Scalars(Constants.BaseUrl);

        Call<String> call = retrofirHelper.connectHttp(name,password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){

                    String infoBean = response.body();

                    JsonHelper jsonHelper = new JsonHelper();

                    String result = jsonHelper.getRusult(infoBean);

                    if(result != null){

                        if(!result.equals("0")){

                            checkUserLoadListener.onCompleted(true);
                        }

                        else

                            checkUserLoadListener.onCompleted(false);

                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                t.printStackTrace();
            }
        });



    }


    // 设置判断的用户名和密码
    public void setUserInfo(String name, String password){

        this.name = name;

        this.password = password;
    }
}
