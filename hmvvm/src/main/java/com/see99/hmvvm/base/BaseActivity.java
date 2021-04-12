package com.see99.hmvvm.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.see99.hmvvm.MyApp;
import com.see99.hmvvm.dagger.component.ActivityComponent;
import com.see99.hmvvm.dagger.component.DaggerActivityComponent;

import javax.inject.Inject;


public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    protected T binding;

    @Inject
    protected V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performInject(getActivityComponent());
        super.onCreate(savedInstanceState);
        performDataBinding();
        initBaseObserver();
    }

    private void initBaseObserver() {
        mViewModel.routers.observe(this, new Observer<Router>() {
            @Override
            public void onChanged(Router router) {
                if (router.getBundle()!=null){
                    performRouter(router.getRouterId(),router.getBundle());
                }else {
                    performRouter(router.getRouterId());
                }
            }
        });
    }

    /**
     * 跳转的方式
     * 带参数跳转
     * 无参数跳转
     *
     * 页面跳转，调试路由传递的参数
     */
    protected  void performRouter(int routerId,Bundle bundle){

    }

    /**
     * 无参数跳转
     * @param routerId
     */
    public void performRouter(int routerId){

    }

    //注入方法
    protected abstract void performInject(ActivityComponent activityComponent);

    private ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .setAppComponent(((MyApp)getApplication()).appComponent)
                .activity(this).build();
    }

    private void performDataBinding() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        binding.setVariable(getVariableId(),mViewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
    }

    //绑定数据的id
    protected abstract int getVariableId();

    @LayoutRes
    public abstract int getLayoutId();

    //隐藏软键盘
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
