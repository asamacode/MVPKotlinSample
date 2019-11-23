package com.asama.luong.mvpkotlinsample.ui.login.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.MVPPresenter
import com.asama.luong.mvpkotlinsample.ui.login.interactor.LoginMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.login.view.LoginMVPView

interface LoginMVPPresenter<V : LoginMVPView, I : LoginMVPInteractor> : MVPPresenter<V, I> {

    fun onServerLoginClicked(email: String, password: String)

    fun onFBLoginClicked()

    fun onGoogleLoginClicked()
}