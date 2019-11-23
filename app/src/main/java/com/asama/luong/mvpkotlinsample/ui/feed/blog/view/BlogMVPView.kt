package com.asama.luong.mvpkotlinsample.ui.feed.blog.view

import com.asama.luong.mvpkotlinsample.data.network.model.Blog
import com.asama.luong.mvpkotlinsample.ui.base.view.MVPView

interface BlogMVPView : MVPView {

    fun displayBlogList(blogs: List<Blog>?) : Unit?
}