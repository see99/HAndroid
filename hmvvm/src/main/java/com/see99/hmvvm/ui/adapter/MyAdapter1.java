package com.see99.hmvvm.ui.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;

import com.see99.hmvvm.R;
import com.see99.hmvvm.databinding.ItemMyBinding;
import com.see99.hmvvm.model.MyTest;
import com.see99.hmvvm.ui.adapter.base.BaseAdapter;
import com.see99.hmvvm.ui.adapter.base.BaseViewHoder;

import javax.inject.Inject;

public class MyAdapter1 extends BaseAdapter<MyTest, ItemMyBinding> {

    @Inject
    public MyAdapter1(){}

    @Override
    public int getItemLayoutId() {
        return R.layout.item_my;
    }

    @Override
    protected int getVariableId() {
        return BR.item;
    }
}
