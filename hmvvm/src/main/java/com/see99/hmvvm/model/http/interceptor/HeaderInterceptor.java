package com.see99.hmvvm.model.http.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * header 拦截器
 * 在header 添加参数
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
//        Log.i("TAG", "intercept: "+chain.request().method());
//        builder.addHeader("token","111");
        return chain.proceed(builder.build());
    }
}
