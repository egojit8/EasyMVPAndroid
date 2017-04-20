package com.egojit.mvp.easyandroid.easymvpandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.egojit.mvp.easyandroid.core.BaseAppComponent;
import com.egojit.mvp.easyandroid.core.base.BaseActivity;
import com.egojit.mvp.easyandroid.easymvpandroid.data.AppApiService;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    AppApiService appApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appApiService.getRecomend("gender");
    }

    @Override
    protected void setupActivityComponent(BaseAppComponent appComponent) {
        ((AppComponent)appComponent).inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
