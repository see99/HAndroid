package com.see99.hmvvm.dagger.component;

import android.app.Application;

import com.see99.hmvvm.MyApp;
import com.see99.hmvvm.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MyApp mApp);

    Application getMyApp();

    @Component.Builder
    interface Builder{

       @BindsInstance
       Builder application(Application application);

        AppComponent build();
    }
}
