package com.see99.hmvvm.dagger.module;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;


import com.see99.hmvvm.Supplier;
import com.see99.hmvvm.ViewModelProviderFactory;
import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.model.http.HttpManager;
import com.see99.hmvvm.ui.login.LoginViewModel;
import com.see99.hmvvm.ui.main.MainViewModel;


import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    LoginViewModel providesLoginViewModel(HttpManager httpManager, BaseActivity<?,?> activity, Application application){
        Supplier<LoginViewModel> supplier = () -> new LoginViewModel(httpManager);
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory(LoginViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(LoginViewModel.class);
//        return new ViewModelProvider(activity,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(LoginViewModel.class);
    }
    @Provides
    MainViewModel providesMainViewModel(HttpManager httpManager, BaseActivity<?,?> activity, Application application){
        Supplier<MainViewModel> supplier = () -> new MainViewModel(httpManager);
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory(MainViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(MainViewModel.class);
//        return new ViewModelProvider(activity,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(LoginViewModel.class);
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
