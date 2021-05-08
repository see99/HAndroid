package com.see99.hmvvmkotlin.dagger.module

import androidx.lifecycle.ViewModelProvider
import com.see99.hmvvmkotlin.base.BaseActivity
import com.see99.hmvvmkotlin.base.BaseFragment
import com.see99.hmvvmkotlin.dagger.scope.ActivityScope
import com.see99.hmvvmkotlin.dagger.scope.FragmentScope
import com.see99.hmvvmkotlin.ui.ViewModelProviderFactory
import com.see99.hmvvmkotlin.ui.coursecenter.CourseCenterViewModel
import com.see99.hmvvmkotlin.ui.learningplaza.LearningPlazaViewModel
import com.see99.hmvvmkotlin.ui.login.LoginViewModel
import com.see99.hmvvmkotlin.ui.my.MyViewModel
import com.see99.hmvvmkotlin.ui.timetable.TimeTableViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class FragmentModule {



    @FragmentScope
    @Provides
    fun provideTimeTableViewModel(fragment: BaseFragment<*, *>): TimeTableViewModel {
        var provider = Provider<TimeTableViewModel>{ TimeTableViewModel() }
        var factory = ViewModelProviderFactory<TimeTableViewModel>(TimeTableViewModel::class.java,provider)
        return ViewModelProvider(fragment,factory).get(TimeTableViewModel::class.java)
    }


    @FragmentScope
    @Provides
    fun provideMyViewModel(fragment: BaseFragment<*, *>): MyViewModel {
        var provider = Provider<MyViewModel>{ MyViewModel() }
        var factory = ViewModelProviderFactory<MyViewModel>(MyViewModel::class.java,provider)
        return ViewModelProvider(fragment,factory).get(MyViewModel::class.java)
    }
    @FragmentScope
    @Provides
    fun provideLearningPlazaViewModel(fragment: BaseFragment<*, *>): LearningPlazaViewModel {
        var provider = Provider<LearningPlazaViewModel>{ LearningPlazaViewModel() }
        var factory = ViewModelProviderFactory<LearningPlazaViewModel>(LearningPlazaViewModel::class.java,provider)
        return ViewModelProvider(fragment,factory).get(LearningPlazaViewModel::class.java)
    }

    @FragmentScope
    @Provides
    fun provideCourseCenterViewModel(fragment: BaseFragment<*, *>): CourseCenterViewModel {
        var provider = Provider<CourseCenterViewModel>{ CourseCenterViewModel() }
        var factory = ViewModelProviderFactory<CourseCenterViewModel>(CourseCenterViewModel::class.java,provider)
        return ViewModelProvider(fragment,factory).get(CourseCenterViewModel::class.java)
    }
}