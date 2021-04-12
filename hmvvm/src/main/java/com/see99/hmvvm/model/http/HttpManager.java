package com.see99.hmvvm.model.http;

import com.see99.hmvvm.model.http.interceptor.HeaderInterceptor;
import com.see99.hmvvm.model.http.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;

public class HttpManager {

    @Singleton
    public HttpManager(){
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                //添加header 拦截器
                .addInterceptor(new HeaderInterceptor())
                //添加logger 拦截器
                .addInterceptor(new LogInterceptor())
                .build();

    }
}
