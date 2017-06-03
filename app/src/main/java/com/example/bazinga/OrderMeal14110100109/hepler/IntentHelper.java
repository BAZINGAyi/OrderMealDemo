package com.example.bazinga.OrderMeal14110100109.hepler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by bazinga on 2017/3/8.
 */

public class IntentHelper {

    public static IntentHelper intentHelper ;

    public static IntentHelper getIntents(){
        if(intentHelper == null)
            intentHelper = new IntentHelper();

        return intentHelper;
    }
    // context this, cs跳转对象 bundle 传递参数

    public void startIntent(Context context, Class<?> aimClass, Bundle bundle) {
        Intent intent = new Intent(context, aimClass);

        if (bundle != null)
            intent.putExtras(bundle);

        context.startActivity(intent);
    }
}
