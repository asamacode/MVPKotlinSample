package com.asama.luong.mvpkotlinsample.ui.main.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.MVPPresenter
import com.asama.luong.mvpkotlinsample.ui.main.interactor.MainMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.main.view.MainMVPView

interface MainMVPPresenter<V: MainMVPView, I: MainMVPInteractor> : MVPPresenter<V, I>{

    fun refreshQuestionCards(): Boolean?

    fun onDrawerOptionAboutClick(): Unit?

    fun onDrawerOptionRateUsClick(): Unit?

    fun onDrawerOptionFeedClick(): Unit?

    fun onDrawerOptionLogoutClick()
}