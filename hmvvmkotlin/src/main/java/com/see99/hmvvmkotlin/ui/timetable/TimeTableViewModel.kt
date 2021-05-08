package com.see99.hmvvmkotlin.ui.timetable

import androidx.lifecycle.MutableLiveData
import com.see99.hmvvmkotlin.base.BaseViewModel

class TimeTableViewModel: BaseViewModel() {
    var text = MutableLiveData<String>()
}