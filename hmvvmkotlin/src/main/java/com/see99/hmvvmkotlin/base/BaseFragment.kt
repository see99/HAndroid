package com.see99.hmvvmkotlin.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.see99.hmvvmkotlin.MyApp
import com.see99.hmvvmkotlin.dagger.component.ActivityComponent
import com.see99.hmvvmkotlin.dagger.component.DaggerActivityComponent
import com.see99.hmvvmkotlin.dagger.component.DaggerFragmentComponent
import com.see99.hmvvmkotlin.dagger.component.FragmentComponent
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {
    @Inject
    lateinit var viewModel: V
    lateinit var binding: T

    var activity: BaseActivity<*, *>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*,*>){
            activity = context
        }
        performInject(fragmentComponent())
    }

    private fun fragmentComponent(): FragmentComponent {

        return DaggerFragmentComponent.builder().fragment(this)
                .appComponent((this.context!!.applicationContext as MyApp).appComponent)
                .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performDataBinding()
        initBaseObserver()
        initView()
        initObserver()

    }
    abstract fun initView()

    abstract fun initObserver()

    private fun performDataBinding() {
        binding.setVariable(getVariableId(), viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

    }

    abstract fun getVariableId(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    private fun initBaseObserver() {
        viewModel.routers.observe(this) {
            if (it.bundle != null) {
                performRouter(it.routerId, it.bundle!!)
            } else {
                performRouter(it.routerId)
            }
        }

    }

    /**
     * 当前页可以跳转到多个页   可以根据routerId  进行判断   默认routerId 为 0
     */
    open fun performRouter(routerId: Int, bundle: Bundle) {
    }

    /**
     * 跳转页面不用传递参数
     */
    open fun performRouter(routerId: Int) {
        if (routerId == 0){
            performRouter()
        }
    }

    /**
     * routerid 默认为 0
     */
    open fun performRouter() {

    }

    /**
     * 注入方法
     */
    abstract fun performInject(fragmentComponent: FragmentComponent)

    private fun activityComponent(): ActivityComponent = DaggerActivityComponent.builder().build()
}