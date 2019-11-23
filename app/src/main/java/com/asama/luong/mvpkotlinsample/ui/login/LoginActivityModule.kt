package com.asama.luong.mvpkotlinsample.ui.login

import com.asama.luong.mvpkotlinsample.ui.login.interactor.LoginInteractor
import com.asama.luong.mvpkotlinsample.ui.login.interactor.LoginMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.login.presenter.LoginMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.login.presenter.LoginPresenter
import com.asama.luong.mvpkotlinsample.ui.login.view.LoginMVPView
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMVPInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>):
            LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = presenter
}