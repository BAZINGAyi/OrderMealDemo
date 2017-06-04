package com.example.bazinga.OrderMeal14110100109.base;

import com.example.bazinga.OrderMeal14110100109.R;

/**
 * Created by bazinga on 2017/4/11.
 */
public class Constants {
    // 购买商品的单位
    public static final String UNIT = "元";
    // 背景图
   // public static final String BG_URL = "http://cn.bing.com/az/hprichbg/rb/HenequenCactus_ZH-CN11794616839_1920x1080.jpg";
    public static final int BG_URL = R.mipmap.bg1;
    // 服务器
    public static String BaseUrl = "http://60.205.189.39/";
    // layout
    public static int ImgPlace[] =
            {R.mipmap.img_foodtype1,R.mipmap.img_foodtyp2,R.mipmap.img_foodtype3};
    // 购买页的评价
    public static String [] ViewPager_Title = {"详细","评价"};

    // 请求网络的判断类型
    public static int DATATYPE_Scalars = 1000;
    public static int DATATYPE_GSON = 1001;

    // 请求网络的服务名称
    public static int SERVICE_LOGIN = 2001;
    public static int SERVICE_PERSONAL = 2002;
    public static int SERVICE_SHOP = 2003;

    // 各种变量的初始码
    public static int INITCODE = -1;

    // 各种变量满足条件后的修改码
    public static int CHECK_SUCESS= 1;

    // 判断返回 boolean 的接口返回值
    public static String JSON_RETURN_SUCEESS = "1";
    public static String JSON_RETURN_FAIL = "0";
    public static String JSON_RETURN_CONNECTION = "collected";
    public static String JSON_RETURN_CONNECTION_SUCCESS = "success";

    // 判断是收藏店铺还是收藏食品
    public static final int COLLECT_SHOP_FLAG = 0;
    public static final int COLLECT_FOOD_FLAG = 1;


}
