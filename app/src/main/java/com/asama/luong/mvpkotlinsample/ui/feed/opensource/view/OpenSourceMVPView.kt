package com.asama.luong.mvpkotlinsample.ui.feed.opensource.view

import com.asama.luong.mvpkotlinsample.data.network.model.OpenSource
import com.asama.luong.mvpkotlinsample.ui.base.view.MVPView

interface OpenSourceMVPView: MVPView {

    fun displayOpenSourceList(blogs: List<OpenSource>?)
}