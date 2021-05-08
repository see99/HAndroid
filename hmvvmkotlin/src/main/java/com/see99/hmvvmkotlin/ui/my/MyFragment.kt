package com.see99.hmvvmkotlin.ui.my

import android.os.Bundle
import com.see99.hmvvmkotlin.BR
import com.see99.hmvvmkotlin.R
import com.see99.hmvvmkotlin.base.BaseFragment
import com.see99.hmvvmkotlin.dagger.component.FragmentComponent
import com.see99.hmvvmkotlin.databinding.FragmentMyBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyFragment : BaseFragment<FragmentMyBinding, MyViewModel>() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
        return R.layout.fragment_my
    }

    override fun performInject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MyFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}