package com.see99.hmvvmkotlin

import android.app.Application
import android.util.Log
import com.see99.hmvvmkotlin.dagger.component.DaggerAppComponent

import com.see99.hmvvmkotlin.dagger.module.AppModule
import javax.inject.Inject

class MyApp : Application(){
     val appComponent = DaggerAppComponent.builder().application(this).build()


    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}