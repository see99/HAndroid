package com.see99.hmvvmkotlin.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.see99.hmvvmkotlin.base.BaseViewModel
import com.see99.hmvvmkotlin.ui.command.Command

class LoginViewModel : BaseViewModel() {
    //用户名的绑定
    var userName:MutableLiveData<String> = MutableLiveData<String>()


    //密码的绑定
    var password = MutableLiveData<String>()

    //用户名清除按钮的显示隐藏绑定
    var clearBtnVisibility: MutableLiveData<Int> = MutableLiveData<Int>()

    var isShowPassword = MutableLiveData<Boolean>()

    fun swichShowPassword() {
        isShowPassword.value = isShowPassword.value == null || !isShowPassword.value!!
    }

    var clearBtn = Command(){->
        userName.value = ""
    }

    var loginClick = Command(){->

        //请求数据
//        Log.i("tag", "登录:11 ")
        setRouterForActivity()
    }


    var onFocusChange = Command{ b ->

        if (b) {
            clearBtnVisibility.setValue(View.VISIBLE)
        } else {
            clearBtnVisibility.setValue(View.INVISIBLE)
        }

    }


}