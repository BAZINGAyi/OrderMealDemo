package com.example.bazinga.OrderMeal14110100109.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.MyPagerAdapter;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.fragment.CommetFoodFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.DetailFoodFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodDetailActivity extends AppCompatActivity {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager_id)
    ViewPager viewpagerId;

    private List<Fragment> mfragments = new ArrayList<>();
    private PagerAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);
        setActionBar();
        initViewPager();
    }

    private void setActionBar() {
        collapsingToolbar.setTitle("鱼香肉丝");
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.icons));
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.icons));
    }

    private void initViewPager() {
        Fragment fragment = new DetailFoodFragment();
        mfragments.add(fragment);
        Fragment fragment1 = new CommetFoodFragment();
        mfragments.add(fragment1);

        madapter = new MyPagerAdapter(getSupportFragmentManager(),mfragments, Constants.ViewPager_Title);
        viewpagerId.setAdapter(madapter);
        tabs.setupWithViewPager(viewpagerId);

    }
}
