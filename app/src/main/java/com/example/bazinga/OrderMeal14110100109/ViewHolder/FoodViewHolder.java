package com.example.bazinga.OrderMeal14110100109.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.bazinga.OrderMeal14110100109.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bazinga on 2017/3/6.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.foodImage)
    ImageView foodImage;
    @BindView(R.id.foodName)
    public TextView foodName;
    public @BindView(R.id.foodPlace)
    TextView foodPlace;
    public @BindView(R.id.foodRank)
    RatingBar foodRank;

    @BindView(R.id.foodPlace1)
    public TextView foodPlace1;

    @BindView(R.id.foodPlace2)
    public TextView foodPlace2;

    public FoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
