package com.asama.luong.mvpkotlinsample.ui.rate

import com.asama.luong.mvpkotlinsample.ui.rate.interactor.RateUsInteractor
import com.asama.luong.mvpkotlinsample.ui.rate.interactor.RateUsMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.rate.presenter.RateUsMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.rate.presenter.RateUsPresenter
import com.asama.luong.mvpkotlinsample.ui.rate.view.RateUsDialogMVPView
import dagger.Module
import dagger.Provides

@Module
class RateUsFragmentModule {

    @Provides
    internal fun provideRateUsInteractor(interactor: RateUsInteractor): RateUsMVPInteractor = interactor

    @Provides
    internal fun provideRateUsPresenter(presenter: RateUsPresenter<RateUsDialogMVPView, RateUsMVPInteractor>)
            : RateUsMVPPresenter<RateUsDialogMVPView, RateUsMVPInteractor> = presenter
}