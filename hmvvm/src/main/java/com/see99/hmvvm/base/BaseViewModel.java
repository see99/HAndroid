package com.see99.hmvvm.base;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.see99.hmvvm.model.http.HttpManager;

public class BaseViewModel extends ViewModel {
    protected HttpManager httpManager;
    //需要几个动态LiveData对象

    /**
     * 跳转的路由
     * 观察路由传递的参数
     */
    MutableLiveData<Router> routers = new MutableLiveData<>();

    public BaseViewModel(HttpManager httpManager){
        this.httpManager = httpManager;
    }

    /**
     * 页面跳转  或  开启服务
     * @param routerId  路由id
     * @param bundle 跳转页面传递的参数
     */
    public void setRouterForActivity(int routerId,Bundle bundle){
         routers.postValue(new Router(routerId,bundle));
    }


}
