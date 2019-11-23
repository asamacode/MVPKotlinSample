package com.asama.luong.mvpkotlinsample.data.database.repository.option

import io.reactivex.Observable
import io.reactivex.Single

interface OptionRepo {

    fun isOptionsRepoEmpty(): Observable<Boolean>

    fun insertOptions(options: List<Options>): Observable<Boolean>

    fun loadOptions(questionId: Long): Single<List<Options>>
}