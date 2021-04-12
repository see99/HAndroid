package com.see99.hmvvm.dagger.module;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.ui.login.LoginViewModel;

import java.util.function.Supplier;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    LoginViewModel providesLoginViewModel(BaseActivity<?,?> activity, Application application){

//        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(dataManager, schedulerProvider);
//        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory<>(LoginViewModel.class, supplier);
//        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
        return new ViewModelProvider(activity,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(LoginViewModel.class);
    }

    @Provides
    BaseActivity provideActivity(BaseActivity<?,?> activity){
        return activity;
    }

    @Provides
    Toast provideToast(BaseActivity activity){
        return Toast.makeText(activity,"测试",Toast.LENGTH_LONG);
    }


}
