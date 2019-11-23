package com.asama.luong.mvpkotlinsample.ui.rate.view

import com.asama.luong.mvpkotlinsample.ui.base.view.MVPView

interface RateUsDialogMVPView : MVPView{

    fun dismissDialog()

    fun showRatingSubmissionSuccessMessage()
}