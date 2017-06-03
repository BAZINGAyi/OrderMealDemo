package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.ShopDetailAdapter;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVPBaseActivity;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.onClick.ListenerType;
import com.example.bazinga.OrderMeal14110100109.presenter.activity.GetShopDetailDataPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowShopDetailView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShopDetailActivity extends MVPBaseActivity<IShowShopDetailView, GetShopDetailDataPersenter>
        implements IShowShopDetailView {

    ShopDetailAdapter shopAdapter;

    @BindView(R.id.food_image_view)
    ImageView foodImageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.shopDeatil_recyclerView)
    RecyclerView shopDeatilRecyclerView;

    @BindView(R.id.collectFloatButton)
    FloatingActionButton collectFloatButton;

    private int shopId = Constants.INITCODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shop_detail);

        ButterKnife.bind(this);

        // 接收上一个 Activity 传来的 商店ID
        getData();

        setToobar();

        initRecyclerView();

        mPresenter.attach(this);

        // SHOPID 在之前需要赋值
        if (shopId != Constants.INITCODE){
            mPresenter.getShopData(shopId);
        }

    }

    @Override
    protected GetShopDetailDataPersenter createPresenter() {
        return new GetShopDetailDataPersenter();
    }


    private void initRecyclerView() {
        GridLayoutManager ll = new GridLayoutManager(this, 2);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        shopDeatilRecyclerView.setLayoutManager(ll);
    }

    private void setToobar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(R.drawable.shop_detail_title).into(foodImageView);
    }

    private void getData() {
        Intent intent = getIntent();
        shopId = intent.getIntExtra(ListenerType.SHOP, Constants.INITCODE);
        String shopname;
        shopname = intent.getStringExtra(ListenerType.SHOP_NAME);
        collapsingToolbar.setTitle(shopname);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showShowData(List<ShopFood> shopList) {

        shopAdapter = new ShopDetailAdapter(shopList, ShopDetailActivity.this);

        shopDeatilRecyclerView.setAdapter(shopAdapter);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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
            if(userId != Constants.INITCODE && shopId != Constants.INITCODE){
                mPresenter.collectShop(userId,shopId);
            }
        }

    }

    @OnClick({R.id.collectFloatButton})
    public void collectFood(){

        final Snackbar snackbar = Snackbar.make(collectFloatButton,R.string.COLLECT_SHOP_CONTENT,Snackbar.LENGTH_LONG);
        snackbar.show();

        snackbar.setAction(R.string.YES, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
                if(userId != Constants.INITCODE && shopId != Constants.INITCODE){
                    mPresenter.checkUserCollection(userId,shopId);
                }
            }
        });

    }
}
