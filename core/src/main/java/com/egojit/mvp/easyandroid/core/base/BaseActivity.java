package com.egojit.mvp.easyandroid.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.egojit.mvp.easyandroid.core.BaseAppComponent;

import butterknife.ButterKnife;

/**
 * =================================================================================================
 * 备注：***
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupActivityComponent(BaseApplication.getsInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(BaseAppComponent appComponent);
    protected abstract int getLayoutId();
}
