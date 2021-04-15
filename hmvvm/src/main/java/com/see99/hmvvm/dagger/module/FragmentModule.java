package com.see99.hmvvm.dagger.module;



import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.see99.hmvvm.Supplier;
import com.see99.hmvvm.ViewModelProviderFactory;
import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.base.BaseFragment;
import com.see99.hmvvm.model.http.HttpManager;
import com.see99.hmvvm.ui.login.LoginViewModel;
import com.see99.hmvvm.ui.main.MainViewModel;

import dagger.Module;
import dagger.Provides;

/*
 * Author: rotbolt
 */

@Module
public class FragmentModule {


    @Provides
    BaseFragment provideActivity(BaseFragment<?,?> fragment){
        return fragment;
    }


    @Provides
    MainViewModel providesMainViewModelxx(HttpManager httpManager, BaseFragment<?,?> fragment, Application application){
        Supplier<MainViewModel> supplier = () -> new MainViewModel(httpManager);
        ViewModelProviderFactory<LoginViewModel> factory = new ViewModelProviderFactory(MainViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(MainViewModel.class);
//        return new ViewModelProvider(activity,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(LoginViewModel.class);
    }

}
