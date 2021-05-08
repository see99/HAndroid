package com.see99.hmvvmkotlin.ui.viewadapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.see99.hmvvmkotlin.ui.command.Command

object  ViewAdapter {

    @JvmStatic
    @BindingAdapter(value = ["onClickCommand"])
    fun onClick(view: View, command:Command){
        command?.let {
            view.setOnClickListener{ _ ->
                it.execute()
            }
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["onFocusChangeCommand"])
    fun onFocusChangeCommand(view: View, command: Command){
        view.setOnFocusChangeListener(){ view: View, b: Boolean ->
            command?.let {
                it.execute(b)
            }
        }
    }
}