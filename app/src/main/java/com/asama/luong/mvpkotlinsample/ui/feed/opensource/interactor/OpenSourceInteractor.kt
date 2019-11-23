package com.asama.luong.mvpkotlinsample.ui.feed.opensource.interactor

import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.network.response.OpenSourceResponse
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class OpenSourceInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : OpenSourceMVPInteractor, BaseInteractor(preferenceHelper, apiHelper) {
    override fun getOpenSourceList(): Observable<OpenSourceResponse> = apiHelper.getOpenSourceApiCall()
}