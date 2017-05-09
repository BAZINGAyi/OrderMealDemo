package com.example.bazinga.OrderMeal14110100109.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.FoodViewHolder;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.ShopDetailViewHolder;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.onClick.FoodAdapterOnClickHandler;
import com.example.bazinga.OrderMeal14110100109.onClick.ShopDetailOnClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazinga on 2017/3/6.
 */

public class ShopDetailAdapter extends RecyclerView.Adapter<ShopDetailViewHolder> {

    private List<ShopFood> datas = new ArrayList<>();

    private Activity activity;

    public ShopDetailAdapter(List<ShopFood> datas, Activity activity){

        this.datas = datas ;

        this.activity = activity;
    }

    @Override
    public ShopDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopfood_display_item,parent,false);

        final ShopDetailViewHolder holder = new ShopDetailViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(ShopDetailViewHolder holder, int position) {

        holder.foodName.setText(datas.get(position).getFoodname());

        holder.foodSummary.setText("\t\t"+datas.get(position).getIntro());

        Glide.with(activity)
                .load(datas.get(position).getPic())
                .error(R.drawable.shop_detail_error)
                .into(holder.foodImage);

        holder.itemView.setOnClickListener(new ShopDetailOnClickHandler(datas.get(position).getFood_id(),activity,
                datas.get(position).getFoodname()));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


}
