package com.asama.luong.mvpkotlinsample.ui.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.ui.base.view.BaseActivity
import com.asama.luong.mvpkotlinsample.ui.login.interactor.LoginMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.login.presenter.LoginMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.main.view.MainActivity
import com.asama.luong.mvpkotlinsample.utils.AppConstants
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginMVPView {
    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    @Inject
    lateinit var presenter: LoginMVPPresenter<LoginMVPView, LoginMVPInteractor>

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            AppConstants.EMPTY_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.empty_email_error_message), Toast.LENGTH_LONG).show()
            AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.invalid_email_error_message), Toast.LENGTH_LONG).show()
            AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this, getString(R.string.empty_password_error_message), Toast.LENGTH_LONG).show()
            AppConstants.LOGIN_FAILURE -> Toast.makeText(this, getString(R.string.login_failure), Toast.LENGTH_LONG).show()
        }
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)
        setOnClickListeners()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    private fun setOnClickListeners() {
        btnServerLogin.setOnClickListener { presenter.onServerLoginClicked(et_email.text.toString(), et_password.text.toString()) }
        ibGoogleLogin.setOnClickListener { presenter.onGoogleLoginClicked() }
        ibFbLogin.setOnClickListener { presenter.onFBLoginClicked() }
    }
}
