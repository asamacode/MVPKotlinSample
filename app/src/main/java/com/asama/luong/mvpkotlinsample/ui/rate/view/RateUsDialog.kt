package com.asama.luong.mvpkotlinsample.ui.rate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.ui.base.view.BaseDialogView
import com.asama.luong.mvpkotlinsample.ui.rate.interactor.RateUsMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.rate.presenter.RateUsMVPPresenter
import kotlinx.android.synthetic.main.dialog_rate_us.*
import javax.inject.Inject

class RateUsDialog : BaseDialogView(), RateUsDialogMVPView {

    @Inject
    internal lateinit var presenter: RateUsMVPPresenter<RateUsDialogMVPView, RateUsMVPInteractor>

    private val TAG = "RateUsDialog"

    companion object {
        fun newInstance() : RateUsDialog{
            return RateUsDialog()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.dialog_rate_us, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        btnLater.setOnClickListener { presenter.onLaterOptionClicked() }
        btnSubmit.setOnClickListener { presenter.onSubmitOptionClicked() }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }


    override fun dismissDialog() {
        super.dismissDialog(TAG)
    }

    override fun showRatingSubmissionSuccessMessage() {
        Toast.makeText(context, getString(R.string.rating_thanks), Toast.LENGTH_LONG).show()
    }

    internal fun show(fragmentManager: FragmentManager) = super.show(fragmentManager, TAG)
}