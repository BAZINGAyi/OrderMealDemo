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

public class CommentViewHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.username)
    TextView username;

    public @BindView(R.id.comment)
    TextView comment;

    public @BindView(R.id.commentTime)
    TextView commentTime;

    public CommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
