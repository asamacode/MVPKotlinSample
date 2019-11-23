package com.asama.luong.mvpkotlinsample.data.network

import com.asama.luong.mvpkotlinsample.data.network.request.LoginRequest
import com.asama.luong.mvpkotlinsample.data.network.response.BlogResponse
import com.asama.luong.mvpkotlinsample.data.network.response.LoginResponse
import com.asama.luong.mvpkotlinsample.data.network.response.LogoutResponse
import com.asama.luong.mvpkotlinsample.data.network.response.OpenSourceResponse
import io.reactivex.Observable

interface ApiHelper {

    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

    fun getBlogApiCall(): Observable<BlogResponse>

    fun getOpenSourceApiCall(): Observable<OpenSourceResponse>
}