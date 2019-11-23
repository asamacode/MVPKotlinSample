package com.asama.luong.mvpkotlinsample.ui.feed.opensource

import androidx.recyclerview.widget.LinearLayoutManager
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.interactor.OpenSourceInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.interactor.OpenSourceMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.presenter.OpenSourceMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.presenter.OpenSourcePresenter
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.view.OpenSourceAdapter
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.view.OpenSourceFragment
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.view.OpenSourceMVPView
import dagger.Module
import dagger.Provides

@Module
class OpenSourceFragmentModule {

    @Provides
    internal fun provideOpenSourceInteractor(interactor: OpenSourceInteractor): OpenSourceMVPInteractor = interactor

    @Provides
    internal fun provideOpenSourcePresenter(presenter: OpenSourcePresenter<OpenSourceMVPView, OpenSourceMVPInteractor>)
            : OpenSourceMVPPresenter<OpenSourceMVPView, OpenSourceMVPInteractor> = presenter

    @Provides
    internal fun provideOpenSourceAdapter(): OpenSourceAdapter = OpenSourceAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: OpenSourceFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}