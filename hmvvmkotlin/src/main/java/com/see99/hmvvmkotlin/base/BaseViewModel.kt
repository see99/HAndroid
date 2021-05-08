package com.see99.hmvvmkotlin.base

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    var routers = MutableLiveData<Router>()

    /**
     * 页面跳转  或  开启服务
     * @param routerId  路由id
     * @param bundle 跳转页面传递的参数
     */
    open fun setRouterForActivity(routerId: Int, bundle: Bundle?) {
        routers.postValue(Router(routerId, bundle))
    }

    open fun setRouterForActivity() {
        routers.postValue(Router(0, null))
    }
}

class Router(var routerId: Int, var bundle: Bundle?)
