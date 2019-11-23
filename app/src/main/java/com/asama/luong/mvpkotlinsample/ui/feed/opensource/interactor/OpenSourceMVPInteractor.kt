package com.asama.luong.mvpkotlinsample.ui.feed.opensource.interactor

import com.asama.luong.mvpkotlinsample.data.network.response.OpenSourceResponse
import com.asama.luong.mvpkotlinsample.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface OpenSourceMVPInteractor: MVPInteractor {

    fun getOpenSourceList(): Observable<OpenSourceResponse>
}