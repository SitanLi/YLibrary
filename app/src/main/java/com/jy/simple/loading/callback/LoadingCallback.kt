package com.jy.simple.loading.callback

import com.jy.baselibrary.loadsir.callback.Callback
import com.jy.simple.R


/**
 * Administrator
 * created at 2018/12/3 9:17
 * description:LoadSir加载页
 */
class LoadingCallback : Callback() {
    override fun onCreateView(): Int = R.layout.loadsir_callback_loading
}