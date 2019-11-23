package com.asama.luong.mvpkotlinsample.ui.main

import com.asama.luong.mvpkotlinsample.ui.main.interactor.MainInteractor
import com.asama.luong.mvpkotlinsample.ui.main.interactor.MainMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.main.presenter.MainMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.main.presenter.MainPresenter
import com.asama.luong.mvpkotlinsample.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor) : MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter
}