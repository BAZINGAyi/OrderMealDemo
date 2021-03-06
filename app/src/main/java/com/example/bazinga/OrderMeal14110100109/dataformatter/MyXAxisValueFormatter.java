package com.example.bazinga.OrderMeal14110100109.dataformatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by bazinga on 2017/6/4.
 */

public class MyXAxisValueFormatter implements IAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyXAxisValueFormatter() {

        // format values to 1 decimal digit
        mFormat = new DecimalFormat("###,###,##0");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        // "value" represents the position of the label on the axis (x or y)
        return "6月" + mFormat.format(value) + " 号";
    }
}
