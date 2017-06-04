package com.example.bazinga.OrderMeal14110100109.hepler;

import android.content.Context;
import android.graphics.Color;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.dataformatter.MyValueFormatter;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazinga on 2017/6/4.
 */

public class ChartHelper {

    public static LineData getLineDataSet(Context context, List<Entry> datas) {
        LineDataSet dataSet = new LineDataSet(datas,
                context.getString(R.string.Oider_Dish_Content));
        //dataSet.set
        dataSet.setDrawCircles(true);
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(Color.rgb(255, 255, 255));
        dataSet.setCubicIntensity(0.9f);

        dataSet.setHighlightEnabled(true);          //设置对数据集显示高亮
        dataSet.setDrawHighlightIndicators(true);
        dataSet.setColors(Color.WHITE);
        dataSet.setCircleColor(Color.BLUE);
        dataSet.setHighLightColor(Color.GREEN);      //设置高亮的颜色
        dataSet.setDrawValues(true);                 //高亮的点显示值
        dataSet.setLabel(context.getString(R.string.Oider_Dish_Content));

        dataSet.setValueTextColor(Color.WHITE);
        LineData lineData = new LineData(dataSet);
        return lineData;
    }

    public static PieData getPieDataSet(List<PieEntry> datas){
        PieDataSet set = new PieDataSet(datas, "");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));
        set.setColors(colors);
        set.setValueFormatter(new MyValueFormatter());
        PieData data = new PieData(set);
        return data;
    }
}
