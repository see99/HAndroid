package com.see99.hmvvm.ui.adapter.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHoder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
    public T binding;
    public BaseViewHoder(@NonNull T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
