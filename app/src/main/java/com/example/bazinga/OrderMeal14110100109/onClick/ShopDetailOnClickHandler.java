package com.example.bazinga.OrderMeal14110100109.onClick;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.bazinga.OrderMeal14110100109.ui.FoodDetailActivity;
import com.example.bazinga.OrderMeal14110100109.ui.ShopDetailActivity;

/**
 * Created by bazinga on 2017/5/7.
 */

public class ShopDetailOnClickHandler implements View.OnClickListener {

        private int objectId;

        private Activity activity;

        private String intro;

        public ShopDetailOnClickHandler(int objectId, Activity activity, String intro) {
            this.objectId = objectId;
            this.activity = activity;
            this.intro = intro;
        }



        @Override
        public void onClick(View v) {

            Intent intent = new Intent(activity, FoodDetailActivity.class);

            intent.putExtra(ListenerType.FOOD_ID, objectId);

            if(intro != null)
            intent.putExtra(ListenerType.SHOP_NAME, intro);

            activity.startActivity(intent);

        }

}
