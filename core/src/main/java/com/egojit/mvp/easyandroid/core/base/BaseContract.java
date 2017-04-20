package com.egojit.mvp.easyandroid.core.base;

/**
 * =================================================================================================
 * 备注：视图约束
 * 作者：高露
 * 时间：2017/4/20.
 * =================================================================================================
 */

public class BaseContract {
    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        void showError();

        void complete();

    }
}
