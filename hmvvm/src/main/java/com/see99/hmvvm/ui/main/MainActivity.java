package com.see99.hmvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.see99.hmvvm.BR;
import com.see99.hmvvm.MyApp;
import com.see99.hmvvm.R;
import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.dagger.component.ActivityComponent;
import com.see99.hmvvm.databinding.ActivityMainBinding;
import com.see99.hmvvm.model.MyTest;
import com.see99.hmvvm.ui.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyAdapter myAdapter = new MyAdapter(this);

        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(myAdapter);

        List<MyTest> list = new ArrayList<>();
        list.add(new MyTest("ni1","wo"));
        list.add(new MyTest("ni","wo"));
        list.add(new MyTest("ni","wo"));
        list.add(new MyTest("ni","wo"));
        myAdapter.setList(list);


    }

    @Override
    protected void performInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getVariableId() {
        return BR.viewMode;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}