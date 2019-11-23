package com.asama.luong.mvpkotlinsample.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.ui.base.view.BaseActivity
import com.asama.luong.mvpkotlinsample.ui.feed.view.FeedActivity
import com.asama.luong.mvpkotlinsample.ui.main.interactor.MainMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.main.interactor.QuestionCardData
import com.asama.luong.mvpkotlinsample.ui.main.presenter.MainMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.rate.view.RateUsDialog
import com.google.android.material.navigation.NavigationView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView, NavigationView.OnNavigationItemSelectedListener,
    HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment> = fragmentDispatchingAndroidInjector

    override fun onFragmentDetached(tag: String) {
//        supportFragmentManager?.removeFragment(tag = tag)
        unlockDrawer()
    }

    override fun onFragmentAttached() {
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_about -> {
                presenter.onDrawerOptionAboutClick()
            }
            R.id.nav_item_rate_us -> {
                presenter.onDrawerOptionRateUsClick()
            }
            R.id.nav_item_feed -> {
                presenter.onDrawerOptionFeedClick()
            }
            R.id.nav_item_logout -> {
                presenter.onDrawerOptionLogoutClick()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @Inject
    lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    override fun inflateUserDetails(userDetails: Pair<String?, String?>) {

    }

    override fun displayQuestionCard(questionCard: List<QuestionCardData>) {

    }

    override fun openLoginActivity() {

    }

    override fun openFeedLoginActivity() {
        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)
    }

    override fun openAboutFragment() {

    }

    override fun openRateUsDialog(): Unit? = RateUsDialog.newInstance().let {
        it.show(supportFragmentManager)
    }

    override fun lockDrawer(): Unit? = drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    override fun unlockDrawer(): Unit? = drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpDraweMenu()
        presenter.onAttach(this)
    }

    private fun setUpDraweMenu() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open_drawer, R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()
    }

}
