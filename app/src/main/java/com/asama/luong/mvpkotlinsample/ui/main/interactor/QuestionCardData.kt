package com.asama.luong.mvpkotlinsample.ui.main.interactor

import com.asama.luong.mvpkotlinsample.data.database.repository.option.Options
import com.asama.luong.mvpkotlinsample.data.database.repository.question.Question

data class QuestionCardData( val option: List<Options>, val question: Question)