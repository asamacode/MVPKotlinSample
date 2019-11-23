package com.asama.luong.mvpkotlinsample.ui.login.interactor

import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.network.request.LoginRequest
import com.asama.luong.mvpkotlinsample.data.network.response.LoginResponse
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.ui.base.interactor.BaseInteractor
import com.asama.luong.mvpkotlinsample.utils.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class LoginInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : LoginMVPInteractor, BaseInteractor(preferenceHelper, apiHelper) {

    override fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse> =
        apiHelper.performServerLogin(LoginRequest.ServerLoginRequest("test1","test1"))

    override fun doFBLoginApiCall(): Observable<LoginResponse> =
        apiHelper.performFBLogin(LoginRequest.FacebookLoginRequest("test3", "test4"))

    override fun doGoogleLoginApiCall(): Observable<LoginResponse> =
        apiHelper.performGoogleLogin(LoginRequest.GoogleLoginRequest("test1", "test1"))

    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) =
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.userId)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserLoggedInMode(loggedInMode)
        }
}