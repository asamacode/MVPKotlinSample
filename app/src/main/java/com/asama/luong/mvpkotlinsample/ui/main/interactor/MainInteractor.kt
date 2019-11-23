package com.asama.luong.mvpkotlinsample.ui.main.interactor

import com.asama.luong.mvpkotlinsample.data.database.repository.option.OptionRepo
import com.asama.luong.mvpkotlinsample.data.database.repository.option.Options
import com.asama.luong.mvpkotlinsample.data.database.repository.question.Question
import com.asama.luong.mvpkotlinsample.data.database.repository.question.QuestionRepo
import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.network.response.LogoutResponse
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val questionRepo: QuestionRepo,
    private val optionRepo: OptionRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : MainMVPInteractor,
    BaseInteractor(preferenceHelper, apiHelper) {

    override fun getQuestionCardData(): Single<List<QuestionCardData>> = questionRepo.loadQuestions()
        .flatMapIterable { question -> question }
        .flatMapSingle { question -> getQuestionCards(question) }
        .toList()

    override fun getUserDetail(): Pair<String?, String?> =
        Pair(preferenceHelper.getCurrentUserName(), preferenceHelper.getCurrentUserEmail())

    override fun makeLogoutApiCall(): Observable<LogoutResponse> = apiHelper.performLogoutApiCall()

    private fun getQuestionCards(question: Question) = optionRepo.loadOptions(question.id)
        .map { options -> createQuestionCard(options, question) }

    private fun createQuestionCard(options: List<Options>, question: Question) = QuestionCardData(options, question)
}