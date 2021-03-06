package com.jy.simple.http.mvvm

import com.jy.commonlibrary.http.RxHelper
import com.jy.commonlibrary.http.bean.HttpEntry
import com.jy.simple.http.api.ApiSimpleService
import com.jy.simple.http.base.BaseModel
import com.jy.simple.http.bean.BannerInfoListVo
import com.jy.simple.http.bean.base.HttpRequest
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**

 * @Author Administrator
 * @Date 2019/9/27-11:46
 * @TODO
 */
class MvvMApiSimpleModel : BaseModel<ApiSimpleService>(ApiSimpleService::class.java) {


    fun getBanner(showPlace: Int): Observable<BannerInfoListVo> {
        return serviceManager.getBanner(HttpRequest.obtainHttpRequest(HttpEntry("showPlace", showPlace)))
                .compose(RxHelper.handleSingleResult())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}