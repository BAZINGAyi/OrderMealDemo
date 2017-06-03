package com.example.bazinga.OrderMeal14110100109.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.CommentViewHolder;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.FoodViewHolder;
import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.onClick.FoodAdapterOnClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bazinga on 2017/3/6.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private List<Comment> datas = new ArrayList<>();

    private Activity activity;

    private static int CURRENT_ITEM = 1;

    private static int CURRENT_EMPTYITEM ;

    public CommentAdapter(List<Comment> datas, Activity activity){

        this.datas = datas ;

        this.activity = activity;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item,parent,false);

        final CommentViewHolder holder = new CommentViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.username.setText(datas.get(position).getUsername());
        holder.comment.setText(datas.get(position).getContent());
        holder.commentTime.setText(datas.get(position).getComment_time());
    }

    @Override
    public int getItemCount() {
            return datas.size();
    }

//    @Override
//    public int getItemCount() {
//        if(datas.size() == 0)
//            return 1;
//        else
//            return datas.size();
//    }


//    @Override
//    public int getItemViewType(int position) {
//
//        if (position == 1) {
//            return CURRENT_EMPTYITEM;
//        } else {
//            return CURRENT_ITEM;
//        }
//
//    }

}
