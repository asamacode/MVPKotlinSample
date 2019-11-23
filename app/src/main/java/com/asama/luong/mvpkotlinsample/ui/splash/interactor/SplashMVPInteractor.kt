package com.asama.luong.mvpkotlinsample.ui.splash.interactor

import com.asama.luong.mvpkotlinsample.data.database.repository.question.Question
import com.asama.luong.mvpkotlinsample.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface SplashMVPInteractor : MVPInteractor {

    fun seedQuestions() : Observable<Boolean>

    fun seedOptions(): Observable<Boolean>

    fun getQuestion() : Observable<List<Question>>
}