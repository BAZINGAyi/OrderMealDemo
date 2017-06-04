package com.example.bazinga.OrderMeal14110100109.dataformatter;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Created by bazinga on 2017/6/4.
 */

public class MyValueFormatter implements IValueFormatter {

    private DecimalFormat mFormat;

    public MyValueFormatter() {

        // format values to 1 decimal digit
        mFormat = new DecimalFormat("###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return  mFormat.format(value) + " %";
    }
}