package com.asama.luong.mvpkotlinsample.ui.main.interactor

import com.asama.luong.mvpkotlinsample.data.network.response.LogoutResponse
import com.asama.luong.mvpkotlinsample.ui.base.interactor.MVPInteractor
import io.reactivex.Observable
import io.reactivex.Single

interface MainMVPInteractor : MVPInteractor {

    fun getQuestionCardData(): Single<List<QuestionCardData>>

    fun getUserDetail(): Pair<String?, String?>

    fun makeLogoutApiCall(): Observable<LogoutResponse>
}