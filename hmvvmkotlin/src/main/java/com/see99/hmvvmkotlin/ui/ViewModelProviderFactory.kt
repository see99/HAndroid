package com.see99.hmvvmkotlin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

class ViewModelProviderFactory<T : ViewModel>(var viewModelClass: Class<T>, var viewModelProvider: Provider<T>) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModelClass)){
            return viewModelProvider.get() as T
        }else{
            throw IllegalArgumentException("Unknown Class name " + viewModelClass.name)
        }
    }

}