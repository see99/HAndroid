package com.see99.hmvvmkotlin.dagger.component

import com.see99.hmvvmkotlin.base.BaseActivity
import com.see99.hmvvmkotlin.dagger.module.ActivityModule
import com.see99.hmvvmkotlin.dagger.scope.ActivityScope
import com.see99.hmvvmkotlin.ui.login.LoginActivity
import com.see99.hmvvmkotlin.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface  ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(loginActivity: MainActivity)

//    fun inject(activity: LoginActivity)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun activity(activity: BaseActivity<*,*>): Builder

        fun appComponent(component: AppComponent): Builder

        fun build(): ActivityComponent
    }
}