package com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor

import com.asama.luong.mvpkotlinsample.data.network.response.BlogResponse
import com.asama.luong.mvpkotlinsample.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface BlogMVPInteractor: MVPInteractor {

    fun getBlogList(): Observable<BlogResponse>
}