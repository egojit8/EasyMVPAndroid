package com.egojit.mvp.easyandroid.easymvpandroid;

import android.content.Context;

import com.egojit.mvp.easyandroid.core.BaseAppComponent;
import com.egojit.mvp.easyandroid.core.module.BaseAppModule;
import com.egojit.mvp.easyandroid.easymvpandroid.data.AppApi;
import com.egojit.mvp.easyandroid.easymvpandroid.module.AppApiModule;
import com.egojit.mvp.easyandroid.easymvpandroid.module.AppModule;

import dagger.Component;

/**
 * =================================================================================================
 * 备注：app组件
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */
@Component(modules = {BaseAppModule.class,AppApiModule.class})
public  interface AppComponent extends BaseAppComponent {

//    AppApi getAppApi();
    void inject(MainActivity activity);
}
