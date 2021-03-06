package com.jy.simple.http.api

import com.jy.commonlibrary.http.bean.SingleBaseBean
import com.jy.simple.http.bean.BannerInfoListVo
import com.jy.simple.http.bean.base.HttpRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Administrator
 * created at 2018/12/11 15:08
 * description:主页接口
 */
interface ApiSimpleService {
    //获取banner
    @POST("call.do?action=home.banner")
    fun getBanner(@Body httpRequest: HttpRequest): Observable<BannerInfoListVo>

    //送礼
    @POST("call.do?action=roomBehavior.sendGift")
    fun sendGift(@Body httpRequest: HttpRequest): Observable<SingleBaseBean>
}