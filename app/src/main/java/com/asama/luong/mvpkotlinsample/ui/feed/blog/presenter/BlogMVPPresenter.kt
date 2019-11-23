package com.asama.luong.mvpkotlinsample.ui.feed.blog.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.MVPPresenter
import com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor.BlogMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.blog.view.BlogMVPView

interface BlogMVPPresenter<V: BlogMVPView, I: BlogMVPInteractor>: MVPPresenter<V, I> {

    fun onViewPrepared()
}