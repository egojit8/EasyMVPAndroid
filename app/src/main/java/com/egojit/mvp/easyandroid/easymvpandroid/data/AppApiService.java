package com.egojit.mvp.easyandroid.easymvpandroid.data;

import com.egojit.mvp.easyandroid.easymvpandroid.model.Recommend;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * =================================================================================================
 * 备注：***
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */

public interface AppApiService {
    @GET("/book/recommend")
    Observable<Recommend> getRecomend(@Query("gender") String gender);


}
