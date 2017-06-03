package com.example.bazinga.OrderMeal14110100109.presenter;

import android.content.Context;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by bazinga on 2017/4/11.
 */

public abstract class BasePresenter<T>  {

    protected WeakReference<T> mViewRef;

    protected T presenterView;

    protected Context context;

    public void attchView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
            Log.i("BasePresenter"," 已经 Gc ....");
        }
    }
    public T getView() {
        return mViewRef.get();
    }

    // 设置需要显示的View
    public void attach(T presenterView){
        this.presenterView = presenterView;
    }

    // 提供给 model 需要的上下文
    public void setContext(Context context){
        this.context = context;
    }

}
