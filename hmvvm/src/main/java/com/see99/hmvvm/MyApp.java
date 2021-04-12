package com.see99.hmvvm;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.see99.hmvvm.dagger.component.AppComponent;
import com.see99.hmvvm.dagger.component.DaggerAppComponent;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

public class MyApp extends Application {

    public AppComponent appComponent;

//    @Inject
//    public Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

    }
}
