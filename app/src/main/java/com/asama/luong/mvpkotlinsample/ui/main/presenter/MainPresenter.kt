package com.asama.luong.mvpkotlinsample.ui.main.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.BasePresenter
import com.asama.luong.mvpkotlinsample.ui.main.interactor.MainMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.main.view.MainMVPView
import com.asama.luong.mvpkotlinsample.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(
    compositeDisposable: CompositeDisposable,
    interactor: I,
    schedulerProvider: SchedulerProvider
) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), MainMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getUserData()
        getQuestionCards()
    }

    override fun refreshQuestionCards(): Boolean? = getQuestionCards()

    override fun onDrawerOptionAboutClick(): Unit? = getView()?.openAboutFragment()

    override fun onDrawerOptionRateUsClick(): Unit? = getView()?.openRateUsDialog()

    override fun onDrawerOptionFeedClick(): Unit? = getView()?.openFeedLoginActivity()

    override fun onDrawerOptionLogoutClick() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(
                it.makeLogoutApiCall()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({
                        interactor?.performUserLogout()
                        getView()?.let {
                            it.hideProgress()
                            it.openLoginActivity()
                        }
                    }, { err -> println(err) })
            )
        }
    }

    private fun getQuestionCards() = interactor?.let {
        compositeDisposable.add(it.getQuestionCardData()
            .compose(schedulerProvider.ioToMainSingleScheduler())
            .subscribe({ questionCard ->
                getView()?.let {
                    if (questionCard.isEmpty()) return@subscribe
                    else it.displayQuestionCard(questionCard)
                }
            }, { err ->
                println(err)
            })
        )
    }

    private fun getUserData() = interactor?.let {
        val userData = it.getUserDetail()
        getView()?.inflateUserDetails(userData)
    }
}