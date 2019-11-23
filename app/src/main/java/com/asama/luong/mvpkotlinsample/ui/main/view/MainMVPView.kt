package com.asama.luong.mvpkotlinsample.ui.main.view

import com.asama.luong.mvpkotlinsample.ui.base.view.MVPView
import com.asama.luong.mvpkotlinsample.ui.main.interactor.QuestionCardData

interface MainMVPView : MVPView {

    fun inflateUserDetails(userDetails: Pair<String?, String?>)

    fun displayQuestionCard(questionCard: List<QuestionCardData>)

    fun openLoginActivity()

    fun openFeedLoginActivity()

    fun openAboutFragment()

    fun openRateUsDialog(): Unit?

    fun lockDrawer(): Unit?

    fun unlockDrawer(): Unit?
}