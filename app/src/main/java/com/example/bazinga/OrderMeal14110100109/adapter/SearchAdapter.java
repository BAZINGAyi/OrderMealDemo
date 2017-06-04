package com.example.bazinga.OrderMeal14110100109.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.FoodViewHolder;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.SearchViewHolder;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.onClick.FoodAdapterOnClickHandler;
import com.example.bazinga.OrderMeal14110100109.onClick.ShopDetailOnClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazinga on 2017/3/6.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private List<SearchFood> datas = new ArrayList<>();

    private List<Integer> shopId = new ArrayList<>();

    private Activity activity;

    public SearchAdapter(List<SearchFood> datas, Activity activity){
        this.datas = datas ;
        this.activity = activity;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_display_item,parent,false);
        final SearchViewHolder holder = new SearchViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.foodName.setText(datas.get(position).getFoodname());
        holder.foodPrice.setText(String.valueOf(datas.get(position).getPrice())+ Constants.UNIT);
        holder.foodRank.setText(String.valueOf(datas.get(position).getRecommand()));
        holder.img_place.setImageResource(ResourceHelper.getImgResourceId());


        Glide.with(activity)
                .load(datas.get(position).getPic())
                .error(R.drawable.ic_no_found_data)
                .into(holder.foodImage);

        holder.itemView.setOnClickListener(new ShopDetailOnClickHandler(datas.get(position).getFood_id(),activity,
                datas.get(position).getFoodname()));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void removeAll(){
        datas.clear();
        notifyDataSetChanged();
    }

    public void addALL(List<SearchFood> searchFoods){
        datas.clear();
        datas = searchFoods;
        notifyDataSetChanged();
    }

}
