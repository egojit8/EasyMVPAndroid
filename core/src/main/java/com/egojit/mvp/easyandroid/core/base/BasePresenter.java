package com.egojit.mvp.easyandroid.core.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * =================================================================================================
 * 备注：基础Presenter
 * 作者：高露
 * 时间：2017/4/20.
 * =================================================================================================
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

protected T mView;
protected CompositeSubscription mCompositeSubscription;

protected void unSubscribe() {
        if (mCompositeSubscription != null) {
        mCompositeSubscription.unsubscribe();
        }
        }

protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
        mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
        }

@Override
public void attachView(T view) {
        this.mView = view;
        }

@Override
public void detachView() {
        this.mView = null;
        unSubscribe();
        }
        }

