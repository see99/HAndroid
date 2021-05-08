package com.see99.hmvvmkotlin.dagger.component

import com.see99.hmvvmkotlin.base.BaseActivity
import com.see99.hmvvmkotlin.base.BaseFragment
import com.see99.hmvvmkotlin.dagger.module.FragmentModule
import com.see99.hmvvmkotlin.dagger.scope.FragmentScope
import com.see99.hmvvmkotlin.ui.coursecenter.CourseCenterFragment
import com.see99.hmvvmkotlin.ui.learningplaza.LearningPlazaFragment
import com.see99.hmvvmkotlin.ui.my.MyFragment
import com.see99.hmvvmkotlin.ui.timetable.TimeTableFragment
import dagger.BindsInstance
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [AppComponent::class])
interface  FragmentComponent {
    fun inject(timeTableFragment: TimeTableFragment)
    fun inject(myFragment: MyFragment)
    fun inject(learningPlazaFragment: LearningPlazaFragment)
    fun inject(courseCenterFragment: CourseCenterFragment)


    @Component.Builder
    interface Builder{
        @BindsInstance
        fun fragment(fragment: BaseFragment<*, *>): Builder

        fun appComponent(component: AppComponent): Builder

        fun build(): FragmentComponent
    }
}