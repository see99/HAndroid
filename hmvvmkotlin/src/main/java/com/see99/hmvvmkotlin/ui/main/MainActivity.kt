package com.see99.hmvvmkotlin.ui.main

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.see99.hmvvmkotlin.BR
import com.see99.hmvvmkotlin.R
import com.see99.hmvvmkotlin.adapter.PagerAdapter
import com.see99.hmvvmkotlin.base.BaseActivity
import com.see99.hmvvmkotlin.dagger.component.ActivityComponent
import com.see99.hmvvmkotlin.databinding.ActivityMainBinding
import com.see99.hmvvmkotlin.ui.coursecenter.CourseCenterFragment
import com.see99.hmvvmkotlin.ui.learningplaza.LearningPlazaFragment
import com.see99.hmvvmkotlin.ui.my.MyFragment
import com.see99.hmvvmkotlin.ui.timetable.TimeTableFragment
import com.see99.utilslib.StatusBarUtils

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val fragments by lazy {
        listOf<Fragment>(
                TimeTableFragment.newInstance("1"),
                LearningPlazaFragment(),
                CourseCenterFragment(),
                MyFragment()
        )
    }

    override fun initView() {

        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.itemBackground = null

        binding.bottomNavigationView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

        binding.bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.item1 ->{
                    binding.vp.setCurrentItem(0,false)
                }
                R.id.item2 ->{
                    binding.vp.setCurrentItem(1,false)

                }
                R.id.item3 -> {
                    binding.vp.setCurrentItem(2,false)

                }
                R.id.item4 -> {
                    binding.vp.setCurrentItem(3,false)
                }
            }
            true
        }
        binding.vp.isUserInputEnabled = false
        binding.vp.offscreenPageLimit = fragments.size
        binding.vp.adapter = PagerAdapter(fragments,this)
    }

    override fun initObserver() {

    }

    override fun getVariableId(): Int {
        return BR.mainViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun performInject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

}