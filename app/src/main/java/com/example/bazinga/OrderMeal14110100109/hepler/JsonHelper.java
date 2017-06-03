package com.example.bazinga.OrderMeal14110100109.hepler;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bazinga on 2017/4/11.
 */

public class JsonHelper {

    public String getRusult(String results){

        try {

            JSONObject jsonObject = new JSONObject(results);

             String re = jsonObject.getString("userid");

            return re;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getRusult_Reg(String results){

        try {
            JSONObject jsonObject = new JSONObject(results);
            String re = jsonObject.getString("success");
            return re;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String tranfromJsonToString(String results,String checkParameter){

        try {
            JSONObject jsonObject = new JSONObject(results);
            String re = jsonObject.getString(checkParameter);
            return re;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
