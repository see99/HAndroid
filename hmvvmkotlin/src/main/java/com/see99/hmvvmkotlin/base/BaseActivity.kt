package com.see99.hmvvmkotlin.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.see99.hmvvmkotlin.MyApp
import com.see99.hmvvmkotlin.R
import com.see99.hmvvmkotlin.dagger.component.ActivityComponent
import com.see99.hmvvmkotlin.dagger.component.DaggerActivityComponent
import com.see99.utilslib.StatusBarUtils
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: V
    lateinit var binding: T


    override fun onCreate(savedInstanceState: Bundle?) {
        performInject(activityComponent())
        super.onCreate(savedInstanceState)
        StatusBarUtils.setStatusBarColor(this, R.color.statusbar)
        performDataBinding()
        initBaseObserver()

        initObserver()
        initView()
    }

    abstract fun initView()

    abstract fun initObserver()

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



    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(getVariableId(), viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

    }

    abstract fun getVariableId(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 注入方法
     */
    abstract fun performInject(activityComponent: ActivityComponent)

//        private fun activityComponent(): ActivityComponent = DaggerActivityComponent.builder()
//            .appComponent((application as MyApp).appComponent).build()

    private fun activityComponent():ActivityComponent{
      return  DaggerActivityComponent.builder().activity(this)
                .appComponent((application as MyApp).appComponent)
                .build()
    }

}