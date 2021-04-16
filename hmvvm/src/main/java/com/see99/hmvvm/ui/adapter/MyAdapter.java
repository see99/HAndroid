package com.see99.hmvvm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.see99.hmvvm.R;
import com.see99.hmvvm.base.BaseActivity;
import com.see99.hmvvm.databinding.ItemMyBinding;
import com.see99.hmvvm.model.MyTest;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoder> {

    private List<MyTest> list;
//MutableLiveData<List<MyTest>> list;
    private Context context;
    public MyAdapter(Context mContext){
//      list = new MutableLiveData<>();
//      list.setValue(new ArrayList<>());
        list = new ArrayList<>();
        this.context = mContext;
    }

    public void setList(List<MyTest> list){
        if (list!=null){
            this.list.clear();
            this.list.addAll(list);

        }

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemMyBinding binding = ItemMyBinding.inflate(((BaseActivity) context).getLayoutInflater());
//        ItemMyBinding binding = ItemMyBinding.inflate(LayoutInflater.from(parent.getContext()));

//        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),getItemLayoutId(),parent,false);
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_my, parent, false);
        return new ViewHoder((ItemMyBinding) binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        MyTest myTest = list.get(position);
        holder.binding.setItem(myTest);
//        holder.binding.tv.setText(myTest.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHoder extends RecyclerView.ViewHolder{

        public  ItemMyBinding binding;

        public ViewHoder(@NonNull ItemMyBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
