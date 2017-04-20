package com.egojit.mvp.easyandroid.core.base;

import android.app.Application;

import com.egojit.mvp.easyandroid.core.BaseAppComponent;

/**
 * =================================================================================================
 * 备注：***
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */

public abstract class BaseApplication extends Application {

    private static BaseApplication sInstance;
    protected BaseAppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance=this;
        setupCompoent();

    }



    protected abstract void setupCompoent();

    public static BaseApplication getsInstance(){
        return sInstance;
    }

    public BaseAppComponent getAppComponent() {
        return appComponent;
    }


}
