package com.see99.hmvvm.model.http;

import android.util.Log;

import com.see99.hmvvm.BuildConfig;
import com.see99.hmvvm.model.http.interceptor.HeaderInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class HttpManager {

    private final ApiService apiService;


    @Inject
    public HttpManager(){
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(s -> Log.e("Interceptor", s));
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                //添加logger 拦截器
                .addInterceptor(logInterceptor)
                //添加header 拦截器
                .addInterceptor(new HeaderInterceptor())

                .build();

        apiService = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

    }

    public ApiService baseService() {
        return apiService;
    }
}
