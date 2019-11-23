package com.asama.luong.mvpkotlinsample.ui.feed.opensource

import com.asama.luong.mvpkotlinsample.ui.feed.opensource.view.OpenSourceFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class OpenSourceFragmentProvider {

    @ContributesAndroidInjector(modules = [(OpenSourceFragmentModule::class)])
    internal abstract fun provideBlogFragmentFactory(): OpenSourceFragment

}