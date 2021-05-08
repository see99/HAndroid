package com.see99.hmvvmkotlin.dagger.module

import androidx.lifecycle.ViewModelProvider
import com.see99.hmvvmkotlin.base.BaseActivity
import com.see99.hmvvmkotlin.dagger.scope.ActivityScope
import com.see99.hmvvmkotlin.ui.ViewModelProviderFactory
import com.see99.hmvvmkotlin.ui.login.LoginViewModel
import com.see99.hmvvmkotlin.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ActivityModule {


//    @ActivityScope
//    @Provides
//    fun provideActivity(activity:BaseActivity<*,*>) = activity


    @ActivityScope
    @Provides
    fun provideLoginViewModel(activity:BaseActivity<*,*>):LoginViewModel{
        var provider = Provider<LoginViewModel>{ LoginViewModel() }
        var factory = ViewModelProviderFactory<LoginViewModel>(LoginViewModel::class.java,provider)
        return ViewModelProvider(activity,factory).get(LoginViewModel::class.java)
    }

    @ActivityScope
    @Provides
    fun provideMainViewModel(activity:BaseActivity<*,*>):MainViewModel{
        var provider = Provider<MainViewModel>{ MainViewModel() }
        var factory = ViewModelProviderFactory<MainViewModel>(MainViewModel::class.java,provider)
        return ViewModelProvider(activity,factory).get(MainViewModel::class.java)
    }


}
