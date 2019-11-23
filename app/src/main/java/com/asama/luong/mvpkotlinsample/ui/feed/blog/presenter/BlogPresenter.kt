package com.asama.luong.mvpkotlinsample.ui.feed.blog.presenter

import com.asama.luong.mvpkotlinsample.ui.base.presenter.BasePresenter
import com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor.BlogMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.blog.view.BlogMVPView
import com.asama.luong.mvpkotlinsample.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class BlogPresenter<V : BlogMVPView, I : BlogMVPInteractor> @Inject constructor(
    interactor: I,
    provider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BlogMVPPresenter<V, I>, BasePresenter<V, I>(interactor, provider, compositeDisposable) {

    override fun onViewPrepared() {
        getView()?.showProgress()

        interactor?.let {
            it.getBlogList()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ blogResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.displayBlogList(blogResponse.data)
                    }
                })
        }
    }
}