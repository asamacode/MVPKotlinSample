package com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor

import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.network.response.BlogResponse
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class BlogInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BlogMVPInteractor, BaseInteractor(preferenceHelper, apiHelper) {

    override fun getBlogList(): Observable<BlogResponse> = apiHelper.getBlogApiCall()
}