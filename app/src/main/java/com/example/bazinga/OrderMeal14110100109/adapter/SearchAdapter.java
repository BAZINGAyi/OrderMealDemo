package com.example.bazinga.OrderMeal14110100109.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.FoodViewHolder;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.onClick.FoodAdapterOnClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazinga on 2017/3/6.
 */

public class SearchAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<Shop> datas = new ArrayList<>();

    private List<Integer> shopId = new ArrayList<>();

    private Activity activity;

    public SearchAdapter(List<Shop> datas, Activity activity){
        this.datas = datas ;
        this.activity = activity;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_display_item,parent,false);
        final FoodViewHolder holder = new FoodViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {

        holder.foodName.setText(datas.get(position).getShopname());
        holder.foodPlace.setText(datas.get(position).getAddress());
        //holder.foodPlace.setText(String.valueOf(datas.get(position).getShop_id()));
        holder.foodRank.setText(String.valueOf(datas.get(position).getLevel()));

        holder.img_place.setImageResource(ResourceHelper.getImgResourceId());

        holder.itemView.setOnClickListener(new FoodAdapterOnClickHandler(datas.get(position).getShop_id(),activity,
                datas.get(position).getShopname()));

        Glide.with(activity)
                .load(datas.get(position).getPic())
                .into(holder.foodImage);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


}
