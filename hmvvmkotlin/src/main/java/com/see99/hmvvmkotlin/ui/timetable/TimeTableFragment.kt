package com.see99.hmvvmkotlin.ui.timetable

import android.os.Bundle
import com.see99.hmvvmkotlin.BR
import com.see99.hmvvmkotlin.R
import com.see99.hmvvmkotlin.base.BaseFragment
import com.see99.hmvvmkotlin.dagger.component.FragmentComponent
import com.see99.hmvvmkotlin.databinding.FragmentTimeTableBinding

class TimeTableFragment: BaseFragment<FragmentTimeTableBinding, TimeTableViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.text.value = it.getString("title")
        }
    }
    override fun initView() {

    }

    override fun initObserver() {

    }

    override fun getVariableId(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_time_table
    }

    override fun performInject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)

    }

    companion object{
        fun newInstance(str:String):TimeTableFragment{
            return TimeTableFragment().apply {
                arguments= Bundle().apply {
                    putString("title",str)
                }
            }
        }
    }

}