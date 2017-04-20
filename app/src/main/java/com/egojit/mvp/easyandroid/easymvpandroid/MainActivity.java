package com.egojit.mvp.easyandroid.easymvpandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.egojit.mvp.easyandroid.core.BaseAppComponent;
import com.egojit.mvp.easyandroid.core.base.BaseActivity;
import com.egojit.mvp.easyandroid.easymvpandroid.data.AppApiService;
import com.egojit.mvp.easyandroid.easymvpandroid.model.RankingList;
import com.egojit.mvp.easyandroid.easymvpandroid.model.Recommend;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends BaseActivity {

    @Inject
    AppApiService appApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ;
        Subscription rxSubscription = appApiService.getRanking().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onCompleted() {

                        Log.e("x","complete");
                    }

                    @Override
                    public void onError(Throwable e) {
//                        LogUtils.e("getRankList:" + e.toString());
                        Log.e("x","error");
                    }

                    @Override
                    public void onNext(JsonObject list) {
                        Log.e("x",list.toString());
//                        BooksByCats cats = new BooksByCats();
//                        cats.books = new ArrayList<>();
//                        for (Rankings.RankingBean.BooksBean bean : books) {
//                            cats.books.add(new BooksByCats.BooksBean(bean._id, bean.cover, bean.title, bean.author, bean.cat, bean.shortIntro, bean.latelyFollower, bean.retentionRatio));
//                        }
//                        mView.showRankList(cats);
                    }
                });
        CompositeSubscription  mCompositeSubscription = new CompositeSubscription();
        mCompositeSubscription.add(rxSubscription);
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
