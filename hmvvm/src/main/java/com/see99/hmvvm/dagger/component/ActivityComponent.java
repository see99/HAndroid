package com.see99.hmvvm.dagger.component;

import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.dagger.module.ActivityModule;
import com.see99.hmvvm.dagger.scope.ActivityScope;
import com.see99.hmvvm.ui.login.LoginActivity;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {


//    void inject(MainActivity activity);

    void inject(LoginActivity loginActivity);

//    @Component.Builder
//    interface Builderx{
//        @BindsInstance
//        Builderx baseAcitvity(BaseActivity<?,?> activity);
//        ActivityComponent build();
//    }

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder activity(BaseActivity<?,?> activity);

        Builder setAppComponent(AppComponent appComponent);
        ActivityComponent build();
    }
}
