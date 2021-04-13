package com.see99.hmvvm.ui.login;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.see99.hmvvm.base.BaseViewModel;
import com.see99.hmvvm.model.http.HttpManager;
import com.see99.hmvvm.ui.command.BindingCommand;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {
    //用户名的绑定
    public MutableLiveData<String> userName = new MutableLiveData<>();
    //密码的绑定
    public MutableLiveData<String> password = new MutableLiveData<>();
    //用户名清除按钮的显示隐藏绑定
    public MutableLiveData<Integer> clearBtnVisibility = new MutableLiveData();

    public MutableLiveData<Boolean> isShowPassword = new MutableLiveData<>();

    //获取焦点是否显示  delet
    public BindingCommand<Boolean> showBtnByFouse = new BindingCommand((hasFocus) -> {
        if ((Boolean) hasFocus) {
            clearBtnVisibility.setValue(View.VISIBLE);
        } else {
            clearBtnVisibility.setValue(View.INVISIBLE);
        }
    });
    // 清除userName 数据
    public BindingCommand clearUserNameText = new BindingCommand(() ->{
        userName.postValue("");
    });

    public LoginViewModel(HttpManager httpManager) {
        this.httpManager = httpManager;
    }

    public void swichShowPassword(){
        isShowPassword.setValue(isShowPassword.getValue()==null||!isShowPassword.getValue());
    }


    public boolean isEmailAndPasswordValid(String userName, String password) {
        if (TextUtils.isEmpty(userName)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String userName, String password) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("userName",userName);
        hashMap.put("pwd",userName);
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
