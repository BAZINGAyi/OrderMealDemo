package com.example.bazinga.OrderMeal14110100109.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.hepler.DialogHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;

/**
 * Created by bazinga on 2017/4/12.
 */

public abstract class MVpBaseFragment<V,T extends BasePresenter<V>> extends Fragment {

    protected T mPresenter;

    private DialogHelper dia = DialogHelper.getDialogHelper();

    protected int userId = Constants.INITCODE;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        mPresenter = createPresenter();
        //内存泄漏
        //关联View
        mPresenter.attchView((V)this);

        setUserId();

    }

    private void setUserId() {
        SharedPreferences prefs = ResourceHelper.getSharePreferences(getContext());
        userId = Integer.valueOf(prefs.getString(getContext().getString(R.string.userId),null));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        super.onDestroy();
        //接触关联
        mPresenter.detachView();
    }

    protected abstract T createPresenter();

    protected void setDialog(String dialogContent){
        dia.setActivity(getActivity());
        dia.setDialogContent(dialogContent);
        dia.displayDialog();
    }
    protected void closeDialog(){
        if (dia != null)
            dia.closeDialog();
    }
}
