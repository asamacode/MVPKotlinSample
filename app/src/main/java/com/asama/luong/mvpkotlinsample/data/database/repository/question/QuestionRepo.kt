package com.asama.luong.mvpkotlinsample.data.database.repository.question

import io.reactivex.Observable

interface QuestionRepo {

    fun isQuestionRepoEmpty(): Observable<Boolean>

    fun insertQuestions(questions: List<Question>): Observable<Boolean>

    fun loadQuestions(): Observable<List<Question>>
}