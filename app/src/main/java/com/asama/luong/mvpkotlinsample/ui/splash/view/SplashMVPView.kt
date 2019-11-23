package com.asama.luong.mvpkotlinsample.ui.splash.view

import com.asama.luong.mvpkotlinsample.ui.base.view.MVPView

interface SplashMVPView : MVPView{

    fun showSuccessToast()

    fun showErrorToast()

    fun openMainActivity()

    fun openLoginActivity()
}