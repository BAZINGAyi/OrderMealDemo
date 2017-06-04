package com.example.bazinga.OrderMeal14110100109.hepler;

import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazinga on 2017/6/4.
 */

public class RandomDataHelper {
    public static List<SearchFood> getShopData(){
        List<SearchFood> infoBean = new ArrayList<>();

        SearchFood searchFood = new SearchFood();
        searchFood.setFood_id(15);
        searchFood.setFoodname("白灼虾");
        searchFood.setPic("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=239127283,1099924372&fm=58");
        searchFood.setPrice(12);
        searchFood.setRecommand(5);
        infoBean.add(searchFood);

        SearchFood searchFood1 = new SearchFood();
        searchFood1.setFood_id(6);
        searchFood1.setFoodname("五花肉");
        searchFood1.setPic("http://i2.muimg.com/593269/804ef719889517d3t.jpg");
        searchFood1.setPrice(25);
        searchFood1.setRecommand(4);
        infoBean.add(searchFood1);

        SearchFood searchFood2 = new SearchFood();
        searchFood2.setFood_id(5);
        searchFood2.setFoodname("乱炖");
        searchFood2.setPic("https://imgsa.baidu.com/baike/s%3D220/sign=cb3d9c580ef41bd5de53eff661da81a0/1f178a82b9014a9040203dcea9773912b31beea3.jpg");
        searchFood2.setPrice(100);
        searchFood2.setRecommand(2);
        infoBean.add(searchFood2);
        return infoBean;
    }

    public static List<Entry> getLineChartData(){
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1f, 2f));
        entries.add(new Entry(2f, 0f));
        entries.add(new Entry(3f, 3f));
        entries.add(new Entry(4f, 2f));
        entries.add(new Entry(5f, 5f));
        entries.add(new Entry(6f, 7f));
        entries.add(new Entry(7f, 1f));
        entries.add(new Entry(8f, 0f));
        entries.add(new Entry(9f, 2f));
        entries.add(new Entry(10f, 3f));
        entries.add(new Entry(11f, 0f));
        entries.add(new Entry(12f, 4f));
        entries.add(new Entry(13f, 1f));
        entries.add(new Entry(14f, 2f));
        entries.add(new Entry(15f, 4f));
        entries.add(new Entry(16f, 0f));
        entries.add(new Entry(17f, 4f));
        entries.add(new Entry(18f, 5f));
        entries.add(new Entry(19f, 1f));
        return entries;
    }
    public static List<PieEntry> getPieChartData(){
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(38.5f, "甜点"));
        entries.add(new PieEntry(6.7f, "早餐"));
        entries.add(new PieEntry(24.0f, "午餐"));
        entries.add(new PieEntry(30.8f, "晚餐"));
        return entries;
    }
}
