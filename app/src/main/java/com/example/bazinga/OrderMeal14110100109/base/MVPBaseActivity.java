package com.example.bazinga.OrderMeal14110100109.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setInternalSystemState();
        //创建Presenter
        mPresenter = createPresenter();
        //内存泄漏
        //关联View
        mPresenter.attchView((V)this);



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
}
