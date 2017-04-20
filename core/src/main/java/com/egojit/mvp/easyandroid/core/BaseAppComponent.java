package com.egojit.mvp.easyandroid.core;

import android.content.Context;

import com.egojit.mvp.easyandroid.core.module.BaseAppModule;

import dagger.Component;

/**
 * =================================================================================================
 * 备注：app组件
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */
@Component(modules = { BaseAppModule.class})
public  interface BaseAppComponent {
    

    Context getContext();
}
