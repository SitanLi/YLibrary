package com.jy.simple

import android.app.Application
import android.content.Context
import android.os.Process
import androidx.multidex.MultiDex
import com.jy.baselibrary.BaseLibraryConfig
import com.jy.baselibrary.loadsir.callback.SuccessCallback
import com.jy.baselibrary.loadsir.core.LoadSir
import com.jy.baselibrary.thread.LoaderConfiguration
import com.jy.baselibrary.utils.AppUtils
import com.jy.baselibrary.utils.CrashUtils
import com.jy.baselibrary.utils.YLogUtils
import com.jy.commonlibrary.db.DBManager
import com.jy.commonlibrary.glide.ImageLoaderConfiguration
import com.jy.simple.db.DBOpenHelper
import com.jy.simple.loading.callback.*
import com.jy.sociallibrary.SDKConfig


class MyApplication : Application() {

    companion object {
        private var instance: MyApplication? = null
        fun getInstance(): MyApplication = instance!!
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        if (instance == null) {
            instance = this
        }
        val pid = Process.myPid() //进程id
        val process: String? = AppUtils.getCurProcessName(this, pid) //进程名
        if (null == process || applicationContext.packageName == process) {
            //初始化基础库
            BaseLibraryConfig.init(this, LoaderConfiguration.beginBuilder().build(), true);
            //初始化接口请求baseUrl
            RequestDomainConfig.init()
            //初始化数据库
            DBManager.initializeInstance(DBOpenHelper.getInstance(applicationContext))
            //初始化imageLoad
            ImageLoaderConfiguration.getInstance().initImageResId(
                R.drawable.load_default_image,
                R.drawable.load_default_image,
                R.drawable.load_default_image
            )
            //初始化loading
            initLoadSir()
            //初始化社会化SDK
            initSocialSDK()
            //初始化crash捕获
            initCrashUtils()
        }
    }

    /**
     * 初始化loading
     */
    private fun initLoadSir() {
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(TimeoutCallback())
            .addCallback(ImageLoadingCallback())
            .setDefaultCallback(SuccessCallback::class.java)
            .setLoadingCallback(LoadingCallback::class.java)
            .setResLayoutIdOfPopWindow(R.layout.loadsir_callback_loading)
            .commit()
    }

    /**
     * 初始化社会化SDK
     */
    private fun initSocialSDK() {
        SDKConfig.beginBuilder()
            .qqAppID("1105229451")
            .wxAppID("wx499feadd9f2855f8")
            .wbAppID("4044733576")
            .wbRedirectUrl("https://api.weibo.com/oauth2/default.html")
            .wbScope("statuses_to_me_read")
            .build(this)
    }

    /**
     * 初始化crash捕获
     */
    private fun initCrashUtils() {
        CrashUtils.init { crashInfo, _ ->
            YLogUtils.eFormat("重启APP，异常信息：%s", crashInfo)
            AppUtils.relaunchApp()
        }
    }
}