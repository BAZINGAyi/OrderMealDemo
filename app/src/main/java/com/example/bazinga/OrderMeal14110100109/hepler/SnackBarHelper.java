package com.example.bazinga.OrderMeal14110100109.hepler;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.bazinga.OrderMeal14110100109.R;

/**
 * Created by bazinga on 2017/5/31.
 */

public class SnackBarHelper {

    public static SnackBarHelper snackBarHelper = null;

    public static SnackBarHelper getSnackBarHelper (){
        if (snackBarHelper == null){
            return new SnackBarHelper();
        } else{
            return snackBarHelper;
        }
    }

    private SnackBarHelper(){};

    public void setSnackBarHelper(int snackBarContent, View view){
        final Snackbar snackbar = Snackbar.make(view, snackBarContent,Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
