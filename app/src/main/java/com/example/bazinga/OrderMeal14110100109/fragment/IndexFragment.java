package com.example.bazinga.OrderMeal14110100109.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.IndexAdapter;
import com.example.bazinga.OrderMeal14110100109.api.ApiShopService;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVpBaseFragment;
import com.example.bazinga.OrderMeal14110100109.bean.Shop;

import com.example.bazinga.OrderMeal14110100109.presenter.index.GetIndexShopDataPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowIndexView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndexFragment extends MVpBaseFragment<IShowIndexView,GetIndexShopDataPersenter>implements
		IShowIndexView {

	@BindView(R.id.recyclerView)

	RecyclerView recyclerView;

	IndexAdapter foodAdapter ;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{

		View view = inflater.inflate(R.layout.tab01, container, false);

		ButterKnife.bind(this,view);

		initRecyclerView();

		mPresenter.attach(this);

		setDialog(getString(R.string.loading));

		mPresenter.getShopData();

		return view;
	}


	private void initRecyclerView() {
		LinearLayoutManager ll = new LinearLayoutManager(getContext());
		ll.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(ll);
	}


	@Override
	protected GetIndexShopDataPersenter createPresenter() {
		return new GetIndexShopDataPersenter();
	}

	@Override
	public void showShowData(List<Shop> shopList) {
		closeDialog();
		foodAdapter = new IndexAdapter(shopList,getActivity());
		recyclerView.setAdapter(foodAdapter);
	}

	@Override
	public void showError(String msg) {
		closeDialog();
		if(msg != null)
			Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
	}
}
