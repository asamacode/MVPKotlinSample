package com.asama.luong.mvpkotlinsample.ui.rate.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.BasePresenter
import com.asama.luong.mvpkotlinsample.ui.rate.interactor.RateUsMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.rate.view.RateUsDialogMVPView
import com.asama.luong.mvpkotlinsample.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RateUsPresenter<V : RateUsDialogMVPView, I : RateUsMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : RateUsMVPPresenter<V, I>,
    BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable) {

    override fun onLaterOptionClicked(): Unit? = getView()?.let { it.dismissDialog() }

    override fun onSubmitOptionClicked(): Unit? = interactor?.let {
        it.submitRating()
        getView()?.let {
            it.showRatingSubmissionSuccessMessage()
            it.dismissDialog()
        }
    }
}