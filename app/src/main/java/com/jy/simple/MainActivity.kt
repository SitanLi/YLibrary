package com.jy.simple

import android.os.Bundle
import android.view.View
import com.jy.baselibrary.base.BaseActivity
import com.jy.simple.aspect.AspectSimpleActivity
import com.jy.simple.bar.BarSimpleActivity
import com.jy.simple.db.DBSimpleActivity
import com.jy.simple.dialog.DialogSimple
import com.jy.simple.http.ApiSimpleActivity
import com.jy.simple.http.DownloadSimpleActivity
import com.jy.simple.http.MvpApiSimpleActivity
import com.jy.simple.http.MvvMApiSimpleActivity
import com.jy.simple.lazy.LazySimpleActivity
import com.jy.simple.loading.LoadingSimpleActivity
import com.jy.simple.mvvm.MvvMLazySimpleActivity
import com.jy.simple.mvvm.MvvMSimpleActivity
import com.jy.simple.permission.PermissionSimpleActivity
import com.jy.simple.pic.PicSimpleActivity
import com.jy.simple.rxbus.RxBusSimpleActivity
import com.jy.simple.selector.SelectorSimpleActivity
import com.jy.simple.social.LoginSimpleActivity
import com.jy.simple.social.PaySimpleActivity
import com.jy.simple.social.ShareSimpleActivity
import com.jy.simple.sp.SpSimpleActivity
import com.jy.simple.timer.TimerSimpleActivity

class MainActivity : BaseActivity() {


    override fun initLayoutID(): Int = R.layout.activity_main

    override fun initUI(savedInstanceState: Bundle?) {
    }


    fun go2Act(v: View) {
        when (v.id) {
            R.id.go_RxBus -> RxBusSimpleActivity.startAct(this)
            R.id.go_Loading -> LoadingSimpleActivity.startAct(this)
            R.id.go_api -> ApiSimpleActivity.startAct(this)
            R.id.go_mvp_api -> MvpApiSimpleActivity.startAct(this)
            R.id.go_download -> DownloadSimpleActivity.startAct(this)
            R.id.showDialog -> DialogSimple(this, R.style.Theme_AppCompat_Dialog).show()
            R.id.go_bar -> BarSimpleActivity.startAct(this)
            R.id.go_share -> ShareSimpleActivity.startAct(this)
            R.id.go_login -> LoginSimpleActivity.startAct(this)
            R.id.go_pay -> PaySimpleActivity.startAct(this)
            R.id.go_timer -> TimerSimpleActivity.startAct(this)
            R.id.go_permission -> PermissionSimpleActivity.startAct(this)
            R.id.go_sp -> SpSimpleActivity.startAct(this)
            R.id.go_pic -> PicSimpleActivity.startAct(this)
            R.id.go_shadow -> SelectorSimpleActivity.startAct(this)
            R.id.go_db -> DBSimpleActivity.startAct(this)
            R.id.go_lazy -> LazySimpleActivity.startAct(this)
            R.id.go_mvvm -> MvvMSimpleActivity.startAct(this)
            R.id.go_mvvm_api -> MvvMApiSimpleActivity.startAct(this)
            R.id.go_mvvm_fragment -> MvvMLazySimpleActivity.startAct(this)
            R.id.go_aop -> AspectSimpleActivity.startAct(this)
        }
    }

}