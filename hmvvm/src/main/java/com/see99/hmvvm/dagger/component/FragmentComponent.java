package com.see99.hmvvm.dagger.component;



import com.see99.hmvvm.base.BaseFragment;
import com.see99.hmvvm.dagger.module.FragmentModule;
import com.see99.hmvvm.dagger.scope.FragmentScope;
import com.see99.hmvvm.ui.text.FragmentTest;

import dagger.BindsInstance;
import dagger.Component;

/*
 * Author: rotbolt
 */

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(FragmentTest fragmentTest);


//    void inject(TestFragment testFragment);

    @Component.Builder
    interface Builder{
        @BindsInstance
        FragmentComponent.Builder fragment(BaseFragment<?,?> fragment);
        FragmentComponent.Builder setAppComponent(AppComponent appComponent);
        FragmentComponent build();
    }
}
