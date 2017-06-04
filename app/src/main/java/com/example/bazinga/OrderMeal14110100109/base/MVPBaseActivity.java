package com.example.bazinga.OrderMeal14110100109.base;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.hepler.DialogHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.presenter.BasePresenter;

/**
 * 现在我们模拟的MVP框架，现在V和P之间有关联，P对Activity有引用，并且现在P进行的是耗时操作
 * 假如activity已经按了返回键，退出了，那么p还是有activity引用，没有放弃，那么p所开辟的内存空间没有被GC
 * 那么这样就造成了内存泄漏
 *
 * 解决方案：用弱引用来解决
 *
 * Created by Administrator on 2016/8/19.
 */
public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;

    DialogHelper dia = DialogHelper.getDialogHelper();

    protected int userId = Constants.INITCODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setInternalSystemState();
        //创建Presenter
        mPresenter = createPresenter();
        //内存泄漏
        //关联View
        mPresenter.attchView((V)this);
        setUserId();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //接触关联
        mPresenter.detachView();
    }

    protected abstract T createPresenter();

    private void setInternalSystemState() {

        if (Build.VERSION.SDK_INT >= 21) {

            View decorView = getWindow().getDecorView();

            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //全屏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    protected void setDialog(String dialogContent){
        dia.setActivity(this);
        dia.setDialogContent(dialogContent);
        dia.displayDialog();
    }
    protected void closeDialog(){
        if (dia != null)
            dia.closeDialog();
    }

    private void setUserId() {
        SharedPreferences prefs = ResourceHelper.getSharePreferences(this);
        String userId = prefs.getString(getString(R.string.userId),null);
        if (userId != null)
        this.userId = Integer.valueOf(userId);
    }
}
