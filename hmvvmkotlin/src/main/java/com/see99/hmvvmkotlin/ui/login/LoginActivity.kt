package com.see99.hmvvmkotlin.ui.login

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.see99.hmvvmkotlin.BR
import com.see99.hmvvmkotlin.R
import com.see99.hmvvmkotlin.base.BaseActivity
import com.see99.hmvvmkotlin.dagger.component.ActivityComponent
import com.see99.hmvvmkotlin.databinding.ActivityLoginBinding
import com.see99.hmvvmkotlin.ui.main.MainActivity
import com.see99.utilslib.StatusBarUtils


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override fun getVariableId(): Int {
        return BR.loginViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun performInject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun initView() {
        StatusBarUtils.transparencyBar(this)

//        val _window: Window = window
//        val params: WindowManager.LayoutParams = _window.getAttributes()
//        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE
//        _window.setAttributes(params)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //背景颜色改为透明
            window.navigationBarColor = Color.parseColor("#99E5FC");
        }





    }

    override fun initObserver() {
        viewModel.isShowPassword.observe(this){
            if (it) {
                binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw)
                binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw_press)
                binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }

    /**
     * 跳转到主页
     */
    override fun performRouter() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}