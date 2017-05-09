package com.example.bazinga.OrderMeal14110100109.hepler;

import java.security.MessageDigest;

/**
 * Created by bazinga on 2017/4/19.
 */

public class SecurityClass {

    public  static String getMD5(String str) {

        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    public static String convertMD5(String inStr){

        if (inStr == null)
            return  null;
        else
            return (getMD5(inStr));

    }
}
