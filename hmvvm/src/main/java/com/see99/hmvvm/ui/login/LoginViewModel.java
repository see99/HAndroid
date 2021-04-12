package com.see99.hmvvm.ui.login;

import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.see99.hmvvm.base.BaseViewModel;
import com.see99.hmvvm.ui.command.BindingCommand;

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


        //设置跳转的参数
        setRouterForActivity(1,null);

    }
}
