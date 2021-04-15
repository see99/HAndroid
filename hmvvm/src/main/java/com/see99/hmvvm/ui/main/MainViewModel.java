package com.see99.hmvvm.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.see99.hmvvm.base.BaseViewModel;
import com.see99.hmvvm.model.http.HttpManager;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {

    MutableLiveData<String> title = new MutableLiveData<>();

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MainViewModel(HttpManager httpManager) {
        super(httpManager);

        title.setValue("测试");
//        loadData();
    }

    private void loadData() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("userName","1111111");
        hashMap.put("pwd","222");
        hashMap.put("type","android_app");
        httpManager.baseService().login(hashMap)
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
                .subscribe(new Observer<HashMap<String,Object>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i("TAG", "onSubscribe: "+Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(@NonNull HashMap<String,Object> s) {
                        Log.i("TAG", "onNext: 返回的数据："+s);
                        Log.i("Thread",Thread.currentThread().getName());
                        //设置跳转的参数
//                        setRouterForActivity(1,null);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("TAG", "onError: "+e.getMessage()+Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("TAG", "onComplete: "+Thread.currentThread().getName());
                    }
                });

    }
}
