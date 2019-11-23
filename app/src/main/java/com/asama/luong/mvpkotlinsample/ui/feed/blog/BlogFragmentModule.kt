package com.asama.luong.mvpkotlinsample.ui.feed.blog

import androidx.recyclerview.widget.LinearLayoutManager
import com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor.BlogInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor.BlogMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.blog.presenter.BlogMVPPresenter
import com.asama.luong.mvpkotlinsample.ui.feed.blog.presenter.BlogPresenter
import com.asama.luong.mvpkotlinsample.ui.feed.blog.view.BlogAdapter
import com.asama.luong.mvpkotlinsample.ui.feed.blog.view.BlogFragment
import com.asama.luong.mvpkotlinsample.ui.feed.blog.view.BlogMVPView
import dagger.Module
import dagger.Provides

@Module
class BlogFragmentModule {

    @Provides
    internal fun provideBlogInteractor(interactor: BlogInteractor) : BlogMVPInteractor = interactor

    @Provides
    internal fun provideBlogPresenter(presenter: BlogPresenter<BlogMVPView, BlogMVPInteractor>)
            : BlogMVPPresenter<BlogMVPView, BlogMVPInteractor> = presenter

    @Provides
    internal fun provideBlogAdapter(): BlogAdapter = BlogAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: BlogFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)
}