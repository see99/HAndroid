package com.see99.hmvvmkotlin.dagger.module

import android.util.Log
import com.see99.hmvvmkotlin.model.http.ApiService
import com.see99.hmvvmkotlin.model.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideClient():OkHttpClient{
        val logInterceptor = HttpLoggingInterceptor { s: String? -> Log.e("Interceptor", s!!) }
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS) //添加logger 拦截器
                .addInterceptor(logInterceptor) //添加header 拦截器
                .addInterceptor(HeaderInterceptor())
                .build()
    }


    @Singleton
    @Provides
    fun provideHttp(client : OkHttpClient, baseUrl : HttpUrl): ApiService {

        return Retrofit.Builder()
                  .baseUrl(baseUrl)
                  .client(client)
                  .addConverterFactory(GsonConverterFactory.create())
                  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                  .build()
                  .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideBaseUrl():HttpUrl{
       return HttpUrl.parse("https://api.github.com/")!!
    }

}