package com.asama.luong.mvpkotlinsample.ui.splash.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.MVPPresenter
import com.asama.luong.mvpkotlinsample.ui.splash.interactor.SplashMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.splash.view.SplashMVPView

interface SplashMVPPresenter<V : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V, I> {

}