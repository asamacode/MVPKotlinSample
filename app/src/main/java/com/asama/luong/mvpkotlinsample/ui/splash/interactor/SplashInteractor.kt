package com.asama.luong.mvpkotlinsample.ui.splash.interactor

import android.content.Context
import com.asama.luong.mvpkotlinsample.data.database.repository.option.OptionRepo
import com.asama.luong.mvpkotlinsample.data.database.repository.option.Options
import com.asama.luong.mvpkotlinsample.data.database.repository.question.Question
import com.asama.luong.mvpkotlinsample.data.database.repository.question.QuestionRepo
import com.asama.luong.mvpkotlinsample.data.network.ApiHelper
import com.asama.luong.mvpkotlinsample.data.preferences.PreferenceHelper
import com.asama.luong.mvpkotlinsample.ui.base.interactor.BaseInteractor
import com.asama.luong.mvpkotlinsample.utils.AppConstants
import com.asama.luong.mvpkotlinsample.utils.FileUtils
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import io.reactivex.Observable
import javax.inject.Inject

class SplashInteractor @Inject constructor(
    private val mContext: Context,
    private val questionRepoHelper: QuestionRepo,
    private val optionRepoHelper: OptionRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), SplashMVPInteractor {

    override fun seedQuestions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()

        return questionRepoHelper.isQuestionRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)
                val questionList = gson.fromJson<List<Question>>(
                    FileUtils.loadJSONFromAsset(
                        mContext,
                        AppConstants.SEED_DATABASE_QUESTIONS
                    ),
                    type
                )
                questionRepoHelper.insertQuestions(questionList)
            } else {
                Observable.just(false)
            }
        }
    }

    override fun seedOptions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return optionRepoHelper.isOptionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Options::class.java)
                val optionsList = gson.fromJson<List<Options>>(
                    FileUtils.loadJSONFromAsset(
                        mContext,
                        AppConstants.SEED_DATABASE_OPTIONS),
                    type)
                optionRepoHelper.insertOptions(optionsList)
            } else
                Observable.just(false)
        }
    }

    override fun getQuestion(): Observable<List<Question>> {
        return questionRepoHelper.loadQuestions()
    }
}