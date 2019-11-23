package com.asama.luong.mvpkotlinsample.ui.login.view

import com.asama.luong.mvpkotlinsample.ui.base.view.MVPView

interface LoginMVPView : MVPView{

    fun showValidationMessage(errorCode: Int)

    fun openMainActivity()
}