package com.asama.luong.mvpkotlinsample.di.builder

import com.asama.luong.mvpkotlinsample.ui.feed.blog.BlogFragmentProvider
import com.asama.luong.mvpkotlinsample.ui.feed.opensource.OpenSourceFragmentProvider
import com.asama.luong.mvpkotlinsample.ui.feed.view.FeedActivity
import com.asama.luong.mvpkotlinsample.ui.login.LoginActivityModule
import com.asama.luong.mvpkotlinsample.ui.login.view.LoginActivity
import com.asama.luong.mvpkotlinsample.ui.main.MainActivityModule
import com.asama.luong.mvpkotlinsample.ui.main.view.MainActivity
import com.asama.luong.mvpkotlinsample.ui.rate.RateUsDialogFragmentProvider
import com.asama.luong.mvpkotlinsample.ui.splash.SplashActivityModule
import com.asama.luong.mvpkotlinsample.ui.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (RateUsDialogFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(BlogFragmentProvider::class), (OpenSourceFragmentProvider::class)])
    abstract fun bindFeedActivity(): FeedActivity
}