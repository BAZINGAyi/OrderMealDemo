package com.example.bazinga.OrderMeal14110100109.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bazinga.OrderMeal14110100109.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bazinga on 2017/3/6.
 */

public class ShopDetailViewHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.foodImage)
    ImageView foodImage;

    @BindView(R.id.foodName)
    public TextView foodName;

    public @BindView(R.id.foodSummary)
    TextView foodSummary;

    public ShopDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
