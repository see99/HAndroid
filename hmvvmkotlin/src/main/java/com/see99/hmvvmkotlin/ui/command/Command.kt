package com.see99.hmvvmkotlin.ui.command

class Command {

    //单纯的点击  传递任何参数
    var click: (() -> Unit)? = null

    var onFocusChange:((b: Boolean) -> Unit)? = null

    constructor(click: (() -> Unit)?){
        this.click = click
    }

    constructor(onFocusChange: ((b: Boolean) -> Unit)?){
        this.onFocusChange = onFocusChange
    }

    open fun execute(){
        click?.let { it() }
    }

    fun execute(b:Boolean){
        onFocusChange?.let { it(b) }
    }
}