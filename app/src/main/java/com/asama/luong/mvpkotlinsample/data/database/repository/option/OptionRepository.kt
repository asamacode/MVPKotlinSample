package com.asama.luong.mvpkotlinsample.data.database.repository.option

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class OptionsRepository @Inject constructor(private val optionsDao: OptionDao) : OptionRepo {

    override fun isOptionsRepoEmpty(): Observable<Boolean> = Observable.just(optionsDao.loadAll().isEmpty())

    override fun insertOptions(options: List<Options>): Observable<Boolean> {
        optionsDao.insertAll(options)
        return Observable.just(true)
    }

    override fun loadOptions(questionId: Long): Single<List<Options>>
            = Single.fromCallable({ optionsDao.loadOptionsByQuestionId(questionId) })

}