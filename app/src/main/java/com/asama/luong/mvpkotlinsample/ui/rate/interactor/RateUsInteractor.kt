package com.asama.luong.mvpkotlinsample.ui.rate.interactor

import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class RateUsInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : RateUsMVPInteractor, BaseInteractor(preferenceHelper, apiHelper) {

    override fun submitRating() {

    }
}