package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.MyPagerAdapter;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVPBaseActivity;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.fragment.CommetFoodFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.DetailFoodFragment;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.onClick.ListenerType;
import com.example.bazinga.OrderMeal14110100109.presenter.activity.FoodDetailActivityPersenter;
import com.example.bazinga.OrderMeal14110100109.presenter.activity.GetShopDetailDataPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowFoodView;
import com.example.bazinga.OrderMeal14110100109.view.IShowShopDetailView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.bazinga.OrderMeal14110100109.R.id.buy;


public class FoodDetailActivity extends MVPBaseActivity<IShowFoodView, FoodDetailActivityPersenter>
        implements IShowFoodView {

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
    @BindView(R.id.collectFloatingAction)
    FloatingActionButton collectFloatingAction;

    private List<Fragment> mfragments = new ArrayList<>();
    private PagerAdapter madapter;

    private int foodId = Constants.INITCODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);
        getIntentInfo();
        setActionBar();
        initViewPager();
        mPresenter.attach(this);
    }

    @Override
    protected FoodDetailActivityPersenter createPresenter() {
        return new FoodDetailActivityPersenter();
    }

    private void getIntentInfo() {
        Intent intent = getIntent();
        foodId = intent.getIntExtra(ListenerType.FOOD_ID, Constants.INITCODE);
        String foodname;
        foodname = intent.getStringExtra(ListenerType.Extra_Info);
        collapsingToolbar.setTitle(foodname);
    }

    private void setActionBar() {
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.icons));
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.icons));
    }

    private void initViewPager() {
        if (foodId != Constants.INITCODE) {
            Bundle bundle = new Bundle();
            bundle.putInt(ListenerType.FOOD_ID, foodId);

            Fragment fragment = new DetailFoodFragment();
            fragment.setArguments(bundle);
            mfragments.add(fragment);

            Fragment fragmentComment = new CommetFoodFragment();
            fragmentComment.setArguments(bundle);
            mfragments.add(fragmentComment);

            madapter = new MyPagerAdapter(getSupportFragmentManager(), mfragments, Constants.ViewPager_Title);
            viewpagerId.setAdapter(madapter);
            tabs.setupWithViewPager(viewpagerId);

        }
    }

    @OnClick({R.id.collectFloatingAction})
    public void collectFood(){

        final Snackbar snackbar = Snackbar.make(collectFloatingAction,R.string.COLLECT_FOOD_CONTENT,Snackbar.LENGTH_LONG);
        snackbar.show();

        snackbar.setAction(R.string.YES, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
                if(userId != Constants.INITCODE && foodId != Constants.INITCODE){
                    mPresenter.checkUserCollection(userId,foodId);
                }
            }
        });

    }

    @Override
    public void showCollectResult(Boolean result) {
        if (result == true){
            Toast.makeText(this, R.string.COllECT_SUCCESS, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, R.string.COLLECT_FAIL, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showCheckCollectResult(Boolean result) {
        if (result == true){
            Toast.makeText(this, R.string.COllECT_CHECK_SUCCESS, Toast.LENGTH_LONG).show();
        }else{
            if(userId != Constants.INITCODE && foodId != Constants.INITCODE){
                mPresenter.collectFood(userId,foodId);
            }
        }

    }
}
