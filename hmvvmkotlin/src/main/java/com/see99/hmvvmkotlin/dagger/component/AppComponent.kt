package com.see99.hmvvmkotlin.dagger.component

import android.app.Application
import com.see99.hmvvmkotlin.MyApp
import com.see99.hmvvmkotlin.dagger.module.AppModule
import com.see99.hmvvmkotlin.model.http.ApiService
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface  AppComponent {

    fun inject(myApp: MyApp)

    fun application():Application

    fun appServiec():ApiService


    @Component.Builder
    interface Builder{

        @BindsInstance
       fun application(application:Application) : Builder

//        fun appModule(model : AppModule) :Builder

        fun build() : AppComponent
    }
}