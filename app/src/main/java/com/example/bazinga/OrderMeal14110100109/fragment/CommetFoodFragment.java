package com.example.bazinga.OrderMeal14110100109.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.CommentAdapter;
import com.example.bazinga.OrderMeal14110100109.adapter.IndexAdapter;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVpBaseFragment;
import com.example.bazinga.OrderMeal14110100109.bean.Comment;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.RetrofirHelper;
import com.example.bazinga.OrderMeal14110100109.modle.detailfood_frg.IgetDetailFoodDataModel;
import com.example.bazinga.OrderMeal14110100109.onClick.ListenerType;
import com.example.bazinga.OrderMeal14110100109.presenter.frag.GetFoodCommentPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCommentView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bazinga on 2017/5/9.
 */

public class CommetFoodFragment extends MVpBaseFragment<IShowCommentView, GetFoodCommentPersenter>
        implements IShowCommentView {
    @BindView(R.id.commentLists)
    RecyclerView commentLists;
    private int foodId = Constants.INITCODE;
    private CommentAdapter commentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_food_comment, container, false);

        ButterKnife.bind(this, view);

        mPresenter.attach(this);

        initRecyclerView();

        Bundle bundle = getArguments();//从activity传过来的Bundle

        if (bundle != null) {
            foodId = bundle.getInt(ListenerType.FOOD_ID);
            if (userId != Constants.INITCODE)
            mPresenter.getCommentData(userId);

        }

        return view;
    }

    private void initRecyclerView() {
        LinearLayoutManager ll = new LinearLayoutManager(getContext());
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        commentLists.setLayoutManager(ll);
    }

    @Override
    protected GetFoodCommentPersenter createPresenter() {
        return new GetFoodCommentPersenter();
    }

    @Override
    public void showShowData(List<Comment> comments) {
        commentAdapter = new CommentAdapter(comments,getActivity());
        commentLists.setAdapter(commentAdapter);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

}
