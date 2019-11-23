package com.asama.luong.mvpkotlinsample.ui.login.interactor

import com.asama.luong.mvpkotlinsample.data.network.response.LoginResponse
import com.asama.luong.mvpkotlinsample.ui.base.interactor.MVPInteractor
import com.asama.luong.mvpkotlinsample.utils.AppConstants
import io.reactivex.Observable

interface LoginMVPInteractor : MVPInteractor{

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun doFBLoginApiCall(): Observable<LoginResponse>

    fun doGoogleLoginApiCall(): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)
}