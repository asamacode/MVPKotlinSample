package com.asama.luong.mvpkotlinsample.ui.rate.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.MVPPresenter
import com.asama.luong.mvpkotlinsample.ui.rate.interactor.RateUsMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.rate.view.RateUsDialogMVPView

interface RateUsMVPPresenter<V: RateUsDialogMVPView, I: RateUsMVPInteractor> : MVPPresenter<V, I>{

    fun onLaterOptionClicked(): Unit?

    fun onSubmitOptionClicked(): Unit?
}