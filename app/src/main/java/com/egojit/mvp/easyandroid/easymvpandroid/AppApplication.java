package com.egojit.mvp.easyandroid.easymvpandroid;

import com.egojit.mvp.easyandroid.core.base.BaseApplication;
import com.egojit.mvp.easyandroid.core.module.BaseAppModule;
import com.egojit.mvp.easyandroid.easymvpandroid.model.base.Base;
import com.egojit.mvp.easyandroid.easymvpandroid.module.AppApiModule;
import com.egojit.mvp.easyandroid.easymvpandroid.module.AppModule;

import dagger.Component;

/**
 * =================================================================================================
 * 备注：***
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */

public class AppApplication extends BaseApplication{



    @Override
    protected void setupCompoent() {
        appComponent = DaggerAppComponent.builder()
                .appApiModule(new AppApiModule())
                .baseAppModule(new BaseAppModule(this))
                .build();
    }

}
