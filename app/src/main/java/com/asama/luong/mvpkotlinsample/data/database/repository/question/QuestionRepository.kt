package com.asama.luong.mvpkotlinsample.data.database.repository.question

import io.reactivex.Observable
import javax.inject.Inject

class QuestionRepository @Inject internal constructor(private val questionDao: QuestionDao) : QuestionRepo {

    override fun isQuestionRepoEmpty(): Observable<Boolean> {
        return Observable.fromCallable({ questionDao.loadAll().isEmpty() })
    }

    override fun insertQuestions(questions: List<Question>): Observable<Boolean> {
        questionDao.insertAll(questions)
        return Observable.just(true)
    }

    override fun loadQuestions(): Observable<List<Question>> = Observable.fromCallable({ questionDao.loadAll() })
}