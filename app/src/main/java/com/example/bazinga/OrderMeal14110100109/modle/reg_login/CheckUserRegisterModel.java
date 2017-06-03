package com.example.bazinga.OrderMeal14110100109.modle.reg_login;

import android.content.Context;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.hepler.FileterHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.JsonHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/4/11.
 */

public class CheckUserRegisterModel implements ICheckUserModel {

    private Map<String,String> userInfos = new HashMap<>();

    private Context context;

    String name ;
    String pass ;
    String passTwo ;
    String phone ;
    String address ;
    String comment ;

    public void setUserInfo(Map<String,String> userInfos , Context context){
        this.userInfos = userInfos;
        this.context = context;
    }

    @Override
    public void loadProgress(final  CheckUserLoadListener checkUserLoadListener) {

        // 注册用户信息

        RetrofirHelper retrofirHelper = RetrofirHelper.getIntents();
        retrofirHelper.start_RetrofirHelper(Constants.DATATYPE_Scalars,Constants.SERVICE_LOGIN,Constants.BaseUrl);
        Boolean goOn = checkUserInfos();

        if(goOn == true){
            Call<String> call = retrofirHelper.connectHttp_reg(
                   name, pass, phone, address, comment
            );

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    if(response.isSuccessful()){
                        String infoBean = response.body();
                        JsonHelper jsonHelper = new JsonHelper();
                        String result = jsonHelper.getRusult_Reg(infoBean);

                        if(result != null){
                            if(!result.equals(Constants.JSON_RETURN_FAIL)){
                                checkUserLoadListener.onCompleted(true,null);
                            } else{
                                checkUserLoadListener.onCompleted(false,null);
                            }

                        }
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    checkUserLoadListener.onCompleted(false,null);
                    t.printStackTrace();
                }
            });

        }else {
            checkUserLoadListener.onCompleted(false,null);
        }
    }

    private Boolean checkUserInfos() {

         FileterHelper fileterHelper = new FileterHelper();

         name = fileterHelper.filter(userInfos.get(context.getString(R.string.reg_name_key)));
         pass = fileterHelper.filter(userInfos.get(context.getString(R.string.reg_password_key)));
         passTwo = fileterHelper.filter(userInfos.get(context.getString(R.string.reg_twopassword_key)));
         phone = fileterHelper.filter(userInfos.get(context.getString(R.string.reg_phone_key)));
         address = fileterHelper.filter(userInfos.get(context.getString(R.string.reg_address_key)));
         comment = fileterHelper.filter(userInfos.get(context.getString(R.string.reg_comment_key)));

        if(name == null || pass == null
                || pass == null || passTwo == null || phone == null || address == null
                || comment == null){
            return false;
        }

        if(!pass.equals(passTwo))
            return false;

        return true;
    }

}
