package com.see99.hmvvm.ui.text;

import com.see99.hmvvm.BR;
import com.see99.hmvvm.R;
import com.see99.hmvvm.base.BaseFragment;
import com.see99.hmvvm.dagger.component.FragmentComponent;
import com.see99.hmvvm.databinding.FragmentTextSeeBinding;
import com.see99.hmvvm.ui.main.MainViewModel;

public class FragmentTest extends BaseFragment<FragmentTextSeeBinding, MainViewModel> {
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_text_see;
    }

    @Override
    protected void performInject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
