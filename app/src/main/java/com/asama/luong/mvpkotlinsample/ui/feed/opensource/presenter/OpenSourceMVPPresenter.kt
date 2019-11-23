package com.asama.luong.mvpkotlinsample.ui.feed.opensource.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.MVPPresenter
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.interactor.OpenSourceMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.view.OpenSourceMVPView

interface OpenSourceMVPPresenter<V: OpenSourceMVPView, I: OpenSourceMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
}