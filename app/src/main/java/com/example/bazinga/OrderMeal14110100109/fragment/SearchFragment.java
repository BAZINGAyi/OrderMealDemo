package com.example.bazinga.OrderMeal14110100109.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.SearchAdapter;
import com.example.bazinga.OrderMeal14110100109.base.MVpBaseFragment;
import com.example.bazinga.OrderMeal14110100109.bean.SearchFood;
import com.example.bazinga.OrderMeal14110100109.customview.Search_View;
import com.example.bazinga.OrderMeal14110100109.hepler.RandomDataHelper;
import com.example.bazinga.OrderMeal14110100109.presenter.index.SearchDataPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowSearchView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SearchFragment extends MVpBaseFragment<IShowSearchView, SearchDataPersenter> implements
        IShowSearchView {

    @BindView(R.id.searchEditView)
    EditText searchEditView;
    @BindView(R.id.searchButton)
    Button searchButton;
    @BindView(R.id.searchRecyclerView)
    RecyclerView searchRecyclerView;

    @BindView(R.id.hintResult)
    TextView hintResult;

    SearchAdapter searchAdapter;

    @BindView(R.id.search_layout)
    Search_View searchLayout;
    @BindView(R.id.requestFocus)
    LinearLayout requestFocus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab02, container, false);

        ButterKnife.bind(this, view);

        initRecyclerView();

        mPresenter.attach(this);

        getRemdomData();

        setParentFocus();

        return view;
    }

    private void setParentFocus() {
        requestFocus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    searchRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    searchRecyclerView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void getRemdomData() {
        searchAdapter = new SearchAdapter(RandomDataHelper.getShopData(), getActivity());
        searchRecyclerView.setAdapter(searchAdapter);
    }


    private void initRecyclerView() {
        LinearLayoutManager ll = new LinearLayoutManager(getContext());
        ll.setOrientation(LinearLayoutManager.HORIZONTAL);
        searchRecyclerView.setLayoutManager(ll);
    }

    @OnClick({R.id.searchButton})
    public void clickSearchButton() {
        //String content = searchEditView.getText().toString();
        String content = searchLayout.getSearchData();
        setFocus();
        collapseSoftInputMethod(getContext(),requestFocus);
        if (content == null) {
            Toast.makeText(getActivity(), R.string.SEARCH_HINT_ERROR, Toast.LENGTH_LONG);
        } else {
            mPresenter.setSearchContent(content);
            mPresenter.getSearchData();
        }
    }

    @Override
    protected SearchDataPersenter createPresenter() {
        return new SearchDataPersenter();
    }

    @Override
    public void showShowData(List<SearchFood> searchFoods) {
        if (searchFoods.size() == 0) {
            hintResult.setVisibility(View.VISIBLE);
            hintResult.setText(getString(R.string.NO_FIND_RESULT));
            searchAdapter.removeAll();
            searchAdapter.addALL(RandomDataHelper.getShopData());
        } else {
            hintResult.setVisibility(View.GONE);
            searchAdapter.removeAll();
            searchAdapter.addALL(searchFoods);
        }
    }

    @Override
    public void showError(String msg) {
        if (msg != null)
            Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void setFocus() {
        // 确保让父布局抢占焦点，这样下次焦点在 EditText 才会出现历史记录
        requestFocus.setFocusable(true);
        requestFocus.setFocusableInTouchMode(true);

        requestFocus.requestFocus();
        requestFocus.requestFocusFromTouch();

    }

    public static void collapseSoftInputMethod(Context context, View v) {
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }


}