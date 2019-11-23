package com.asama.luong.mvpkotlinsample.ui.splash.view

import android.content.Intent
import android.os.Bundle
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.ui.base.view.BaseActivity
import com.asama.luong.mvpkotlinsample.ui.login.view.LoginActivity
import com.asama.luong.mvpkotlinsample.ui.main.view.MainActivity
import com.asama.luong.mvpkotlinsample.ui.splash.interactor.SplashMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.splash.presenter.SplashMVPPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashMVPView {
    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    @Inject
    lateinit var presenter: SplashMVPPresenter<SplashMVPView, SplashMVPInteractor>

    override fun showSuccessToast() {

    }

    override fun showErrorToast() {

    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
