package com.example.bazinga.OrderMeal14110100109.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.dataformatter.MyValueFormatter;
import com.example.bazinga.OrderMeal14110100109.dataformatter.MyXAxisValueFormatter;
import com.example.bazinga.OrderMeal14110100109.dataformatter.MyYAxisValueFormatter;
import com.example.bazinga.OrderMeal14110100109.hepler.ChartHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RandomDataHelper;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PreferenceDataFragment extends Fragment {
    @BindView(R.id.chartSleep)
    BarChart mBarChart;
    @BindView(R.id.pieChartSleep)
    PieChart mChart;
    @BindView(R.id.chart)
    LineChart chart;

    private List<Entry> entries = new ArrayList<Entry>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab03, container, false);
        ButterKnife.bind(this, view);
        initLineChart();
        setPieData();
        return view;
    }

    
    private void setPieData() {
        Legend le = mChart.getLegend();      //设置说明
        le.setTextColor(Color.WHITE);
        mChart.animateY(2000, Easing.EasingOption.Linear);
        mChart.animateX(2000, Easing.EasingOption.Linear);
        mChart.setData(ChartHelper.getPieDataSet(RandomDataHelper.getPieChartData()));
        mChart.invalidate();

    }

    private void drawAxis() {
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setValueFormatter(new MyYAxisValueFormatter());


        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter());

        chart.getAxisLeft().setEnabled(true); // no right axis
        chart.getAxisRight().setEnabled(false); // no right axis
        chart.getAxisLeft().setTextColor(Color.WHITE);
        chart.getXAxis().setTextColor(Color.WHITE);

    }

    private void initLineChart() {
        chart.setData(ChartHelper.getLineDataSet(getContext(),RandomDataHelper.getLineChartData()));
        chart.setDoubleTapToZoomEnabled(true);      //双击是否放大
        chart.setHighlightPerDragEnabled(false);    //设置高亮的连续可拖动的突出显示
        chart.setHighlightPerTapEnabled(true);      //设置每次点击显示高亮
        chart.setMaxHighlightDistance(1000);        //设置选择高亮的区域范围

        //设置显示高亮的默认值
        Highlight highlight = new Highlight(36.5f, 0, 0);
        chart.highlightValue(highlight, false);

        //设置横轴
        drawAxis();

        chart.animateY(2000, Easing.EasingOption.Linear);
        chart.animateX(2000, Easing.EasingOption.Linear);
        Legend le = chart.getLegend();      //设置说明
        le.setTextColor(Color.BLACK);
        chart.invalidate(); // refresh

    }


}