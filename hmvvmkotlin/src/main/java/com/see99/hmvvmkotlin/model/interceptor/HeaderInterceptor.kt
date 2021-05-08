package com.see99.hmvvmkotlin.model.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
//        Log.i("TAG", "intercept: "+chain.request().method());
//        builder.addHeader("token","111");
        //        Log.i("TAG", "intercept: "+chain.request().method());
//        builder.addHeader("token","111");
        return chain.proceed(builder.build())
    }
}