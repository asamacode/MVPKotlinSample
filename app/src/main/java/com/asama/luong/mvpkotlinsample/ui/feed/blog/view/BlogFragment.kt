package com.asama.luong.mvpkotlinsample.ui.feed.blog.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.data.network.model.Blog
import com.asama.luong.mvpkotlinsample.ui.base.view.BaseFragment
import com.asama.luong.mvpkotlinsample.ui.feed.blog.interactor.BlogMVPInteractor
import com.asama.luong.mvpkotlinsample.ui.feed.blog.presenter.BlogMVPPresenter
import kotlinx.android.synthetic.main.fragment_blog.*
import javax.inject.Inject

class BlogFragment : BaseFragment(), BlogMVPView {

    @Inject
    internal lateinit var blogAdapter: BlogAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: BlogMVPPresenter<BlogMVPView, BlogMVPInteractor>

    companion object {
        fun newInstance() : BlogFragment {
            return BlogFragment()
        }
    }

    override fun setUp() {
        layoutManager.orientation = RecyclerView.VERTICAL
        blog_recycler_view.layoutManager = layoutManager
        blog_recycler_view.itemAnimator = DefaultItemAnimator()
        blog_recycler_view.adapter = blogAdapter
        presenter.onViewPrepared()
    }

    override fun displayBlogList(blogs: List<Blog>?): Unit? = blogs?.let {
        blogAdapter.addBlogsToList(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_blog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

}
