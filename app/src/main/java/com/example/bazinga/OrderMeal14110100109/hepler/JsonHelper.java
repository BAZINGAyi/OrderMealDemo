package com.example.bazinga.OrderMeal14110100109.hepler;

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
}
