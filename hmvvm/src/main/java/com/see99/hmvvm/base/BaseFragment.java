package com.see99.hmvvm.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.see99.hmvvm.MyApp;
import com.see99.hmvvm.dagger.component.ActivityComponent;
import com.see99.hmvvm.dagger.component.DaggerActivityComponent;
import com.see99.hmvvm.dagger.component.DaggerFragmentComponent;
import com.see99.hmvvm.dagger.component.FragmentComponent;

import javax.inject.Inject;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private BaseActivity mActivity;

    private T binding;

//    @Inject
    private V mViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity){
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performInject(getFragmentComponent());
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVariable(getBindingVariable(), mViewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
    }

    public abstract int getBindingVariable();

    @LayoutRes
    protected abstract int getLayoutId();

    //注入方法
    protected abstract void performInject(FragmentComponent fragmentComponent);

    private FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .setAppComponent(((MyApp)(getContext().getApplicationContext())).appComponent)
                .fragment(this)
                .build();
    }
}
