package com.asama.luong.mvpkotlinsample.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asama.luong.mvpkotlinsample.utils.CommonUtils
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog : ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideProgress() {
        progressDialog?.let {
            if (it.isShowing)
                it.cancel()
        }
    }

    private fun performDI() = AndroidInjection.inject(this)
}