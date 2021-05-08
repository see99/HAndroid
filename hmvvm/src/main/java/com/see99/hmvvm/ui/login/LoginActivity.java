package com.see99.hmvvm.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.see99.hmvvm.BR;
import com.see99.hmvvm.ui.main.MainActivity;
import com.see99.hmvvm.R;
import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.dagger.component.ActivityComponent;
import com.see99.hmvvm.databinding.ActivityLoginBinding;
//import com.see99.utilslib.StatusBarUtils;


public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements View.OnClickListener {

//    @Inject
//    Toast toast;

    @Override
    protected void performInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getVariableId() {
        return BR.loginViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StatusBarTools.transparencyBar(this);

//        StatusBarUtils.transparencyBar(this);

        initObserver();
        initClick();
    }

    private void initClick() {
        binding.btLogin.setOnClickListener(this);

    }

    private void initObserver() {
        mViewModel.isShowPassword.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw);
                    binding.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw_press);
                    binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
//        toast.setText("nkdkdk");
//        toast.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                login();
                break;
        }
    }

    private void login() {
        //登录的email
        String userName = binding.etUserName.getText().toString();
        //登录的密码
        String password = binding.etPassword.getText().toString();
        if (mViewModel.isEmailAndPasswordValid(userName, password)) {
            hideKeyboard();
            mViewModel.login(userName, password);
        } else {
            //密码为空  toast提示
            Toast.makeText(this,"账号密码有误！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void performRouter(int routerId){
        startActivity(new Intent(this,MainActivity.class));
    }
}
