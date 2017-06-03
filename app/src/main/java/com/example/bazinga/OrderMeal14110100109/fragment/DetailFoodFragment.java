package com.example.bazinga.OrderMeal14110100109.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVpBaseFragment;
import com.example.bazinga.OrderMeal14110100109.bean.Food;
import com.example.bazinga.OrderMeal14110100109.hepler.DialogHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.onClick.ListenerType;
import com.example.bazinga.OrderMeal14110100109.presenter.frag.GetFoodDetailDataPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowFoodDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bazinga on 2017/5/9.
 */

public class DetailFoodFragment extends MVpBaseFragment<IShowFoodDetailView, GetFoodDetailDataPersenter>
        implements IShowFoodDetailView {

    @BindView(R.id.foodName1)
    TextView foodName;
    @BindView(R.id.foodInfo)
    TextView foodInfo;
    @BindView(R.id.addNumber)
    Button addNumber;
    @BindView(R.id.remNumber)
    Button remNumber;
    @BindView(R.id.buy)
    Button buy;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.number)
    TextView number;

    private int InitFoodCount = 1;

    private int foodId = Constants.INITCODE;
    private int foodCount = InitFoodCount;
    private float foodPrice = Constants.INITCODE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frg_food_detail, container, false);

        ButterKnife.bind(this, view);

        mPresenter.attach(this);

        Bundle bundle = getArguments();//从activity传过来的Bundle

        if (bundle != null) {
            foodId = bundle.getInt(ListenerType.FOOD_ID);
            mPresenter.getFoodData(foodId);
        }

        return view;

    }

    private void initPresenterPrice() {
        foodPrice = Float.valueOf(price.getText().toString().replace(Constants.UNIT,""));
        if(foodPrice != 0)
            mPresenter.setPrice(foodPrice);
    }

    @Override
    protected GetFoodDetailDataPersenter createPresenter() {
        return new GetFoodDetailDataPersenter();
    }

    @Override
    public void showShowData(Food food) {
        number.setText(InitFoodCount+"");
        foodName.setText(food.getFoodname());
        foodInfo.setText(food.getIntro());
        price.setText(String.valueOf(food.getPrice())+Constants.UNIT);
        initPresenterPrice();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPrice(float price) {
        this.price.setText(String.valueOf(price)+ ResourceHelper.getUnit());
    }

    @Override
    public void showBuy(Boolean result) {
        if (result == true){
            Toast.makeText(getContext(), getString(R.string.BUY_SUCCESS), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getContext(), getString(R.string.BUY_FAIL), Toast.LENGTH_LONG).show();
        }
    }

    @OnClick({ R.id.addNumber})
    public void addCount() {
        getFoodCount();
        foodCount = foodCount + 1;
        setFoodCount();
        mPresenter.getFoodPrice(foodCount);
    }

    @OnClick({ R.id.remNumber})
    public void removeCount() {
        getFoodCount();
        if(foodCount > 0){
            foodCount = foodCount - 1;
            setFoodCount();
            mPresenter.getFoodPrice(foodCount);
        }
    }

    @OnClick({R.id.buy})
    public void buyFood(){

        final Snackbar snackbar = Snackbar.make(buy,R.string.BUY_HINT_CONTNET,Snackbar.LENGTH_LONG);
        snackbar.show();

        snackbar.setAction(R.string.YES, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
                if(userId != Constants.INITCODE && foodPrice != Constants.INITCODE
                        && foodCount != Constants.INITCODE && foodId != Constants.INITCODE &&
                        foodCount > 0){
                    mPresenter.buyFood(userId,foodId,foodCount,foodPrice);
                }
            }
        });

    }

    //  更新价格和数量
    private void getFoodCount(){
        foodCount = Integer.valueOf(number.getText().toString());
    }

    private void setFoodCount(){
        number.setText(String.valueOf(foodCount));
    }
}
