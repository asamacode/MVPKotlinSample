package com.asama.luong.mvpkotlinsample.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.asama.luong.mvpkotlinsample.utils.CommonUtils
import dagger.android.support.AndroidSupportInjection

abstract class BaseDialogView : DialogMVPView, DialogFragment() {

    private var parentActivity: BaseActivity? = null
    private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDepecdencyInjection()
    }

    override fun show(manager: FragmentManager, tag: String?) {
        val transaction = manager.beginTransaction()

        val prevFragment = manager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction?.remove(prevFragment)
        }

        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    override fun hideProgress() {
        if (progressDialog != null && progressDialog?.isShowing!!) {
            progressDialog?.cancel()
        }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this.context)
    }

    private fun performDepecdencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    fun dismissDialog(tag: String) {
        dismiss()
        getBaseActivity()?.onFragmentDetached(tag)
    }

    private fun getBaseActivity(): BaseActivity? {
        return parentActivity
    }
}