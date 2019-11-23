package com.asama.luong.mvpkotlinsample.ui.splash

import com.asama.luong.mvpkotlinsample.ui.splash.interactor.SplashInteractor
import com.asama.luong.mvpkotlinsample.ui.splash.interactor.SplashMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.splash.presenter.SplashMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.splash.presenter.SplashPresenter
import com.asama.luong.mvpkotlinsample.ui.splash.view.SplashMVPView
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMVPInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>):
            SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> =
        splashPresenter
}