package com.example.bazinga.OrderMeal14110100109.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.ViewHolder.FoodViewHolder;

/**
 * Created by bazinga on 2017/3/6.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    //private 	List<SchoolFood> datas = new ArrayList<>();

  //  private Context context;

   // public FoodAdapter(	List<SchoolFood> datas,Context context){

  //      this.datas = datas ;

  //      this.context = context;
 //   }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_display_item,parent,false);

        final FoodViewHolder holder = new FoodViewHolder(view);

        return holder;
    }




    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
//        holder.foodName.setText(datas.get(position).getName());
//        holder.foodPlace.setText(datas.get(position).getDescription());
//        holder.foodPlace1.setText(datas.get(position).getFood());
//        holder.foodPlace2.setText(datas.get(position).getFood());
       // holder.foodRank.setRating(datas.get(position).getFoodRank());
       // holder.foodRank.setNumStars(5);
      //  holder.foodImage.setImageResource(R.mipmap.ic_launcher);

//        holder.foodName.setText(datas.get(position).getShopname());
//        holder.foodPlace.setText(String.valueOf(datas.get(position).getShop_id()));
//        holder.foodPlace1.setText(datas.get(position).getAddress());
//        holder.foodPlace2.setText(datas.get(position).getAddress());
//        holder.foodRank.setNumStars(datas.get(position).getLevel());
//        Glide.with(context)
//                .load(datas.get(position).getPic())
//                .into(holder.foodImage);

//        Glide
//                .with(context)
//                //.load("http://www.tngou.net"+datas.get(position).getImg())
//                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489571076386&di=ca700d00f6d770f373e2aae8bf438015&imgtype=0&src=http%3A%2F%2Fimg01.taopic.com%2F150515%2F267858-1505150P55193.jpg")
//                .into(holder.foodImage);
       // Log.d("weixiFragment", "http://www.tngou.net/api"+datas.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return 0;
        //return datas.size();
    }


}
