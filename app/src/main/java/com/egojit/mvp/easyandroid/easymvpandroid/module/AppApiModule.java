package com.egojit.mvp.easyandroid.easymvpandroid.module;

import com.egojit.mvp.easyandroid.easymvpandroid.BuildConfig;
import com.egojit.mvp.easyandroid.easymvpandroid.data.AppApi;
import com.egojit.mvp.easyandroid.easymvpandroid.data.AppApiService;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;

/**
 * =================================================================================================
 * 备注：AppApiModule
 * 作者：高露
 * 时间：2017/4/19.
 * =================================================================================================
 */
@Module
public class AppApiModule {
    @Provides
    public OkHttpClient provideOkHttpClient() {

//        LoggingInterceptor logging = new LoggingInterceptor(new LoggingInterceptor.Builder().);
//        logging.setLevel(LoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new LoggingInterceptor.Builder()
                        .loggable(BuildConfig.DEBUG)
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .request("Request")
                        .response("Response")
                        .addHeader("version", BuildConfig.VERSION_NAME)
                        .build());
        return builder.build();
    }

    @Provides
    protected AppApiService provideAppApiService(OkHttpClient okHttpClient) {
        return AppApi.getInstance(okHttpClient).getService();
    }
}
