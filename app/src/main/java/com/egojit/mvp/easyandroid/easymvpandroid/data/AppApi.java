/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.egojit.mvp.easyandroid.easymvpandroid.data;

import com.egojit.mvp.easyandroid.easymvpandroid.base.Constant;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class AppApi {

    public static AppApi instance;

    private AppApiService service;

    public AppApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(AppApiService.class);
    }

    public static AppApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new AppApi(okHttpClient);
        return instance;
    }

    public AppApiService getService() {
        return service;
    }

    //    public Observable<Recommend> getRecommend(String gender) {
//        return service.getRecomend(gender);
//    }
//
//    public Observable<HotWord> getHotWord() {
//        return service.getHotWord();
//    }

}
