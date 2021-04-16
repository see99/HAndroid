package com.see99.hmvvm.ui.adapter.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.see99.hmvvm.BR;
import com.see99.hmvvm.base.BaseViewModel;
import com.see99.hmvvm.ui.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T,V extends ViewDataBinding> extends RecyclerView.Adapter<BaseViewHoder<V>> {

    protected ArrayList<T> items;
    public BaseAdapter(){
         items = new ArrayList<>();
    }
    public ArrayList<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        if (items!=null){
            this.items.clear();
            this.items.addAll(items);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHoder<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        V binding = (V) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getItemLayoutId(), parent, false);
        return new BaseViewHoder<V>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHoder<V> holder, int position) {
        T item = items.get(position);
        holder.binding.setVariable(getVariableId(),item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * 页面布局
     * @return
     */
    @LayoutRes
    public abstract int getItemLayoutId();

    //绑定数据的id
    protected abstract int getVariableId();
}
