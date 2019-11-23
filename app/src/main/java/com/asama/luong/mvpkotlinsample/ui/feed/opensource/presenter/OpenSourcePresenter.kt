package com.asama.luong.mvpkotlinsample.ui.feed.opensource.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.BasePresenter
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.interactor.OpenSourceMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.view.OpenSourceMVPView
import com.asama.luong.mvpkotlinsample.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class OpenSourcePresenter<V : OpenSourceMVPView, I : OpenSourceMVPInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : OpenSourceMVPPresenter<V, I>,
    BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable) {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getOpenSourceList()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { openSourceResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.displayOpenSourceList(openSourceResponse.data)
                    }
                })
        }
    }
}