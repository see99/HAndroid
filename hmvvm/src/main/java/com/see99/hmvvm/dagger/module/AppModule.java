package com.see99.hmvvm.dagger.module;

import android.app.Application;
import android.content.Context;

import com.see99.hmvvm.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return  application;
    }

//    @Provides
//    String provideBaseUrl(){
//        return BuildConfig.BASE_URL;
//    }
}
