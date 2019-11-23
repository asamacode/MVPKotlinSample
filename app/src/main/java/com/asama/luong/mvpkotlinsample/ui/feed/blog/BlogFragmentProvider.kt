package com.asama.luong.mvpkotlinsample.ui.feed.blog

import com.asama.luong.mvpkotlinsample.ui.feed.blog.view.BlogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class BlogFragmentProvider {

    @ContributesAndroidInjector(modules = [BlogFragmentModule::class])
    internal abstract fun provideFragmentFactory(): BlogFragment
}