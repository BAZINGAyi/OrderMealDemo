package com.example.bazinga.OrderMeal14110100109.hepler;

import com.example.bazinga.OrderMeal14110100109.base.Constants;

import java.util.Random;

/**
 * Created by bazinga on 2017/5/7.
 */

public class ResourceHelper {
    public static int getImgResourceId(){
        Random random = new Random();

        int r = random.nextInt(2);

        return Constants.ImgPlace[r];

    }
}
