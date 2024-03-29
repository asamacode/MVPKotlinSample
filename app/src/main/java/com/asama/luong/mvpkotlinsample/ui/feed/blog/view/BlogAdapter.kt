package com.asama.luong.mvpkotlinsample.ui.feed.blog.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.data.network.model.Blog
import kotlinx.android.synthetic.main.item_blog_list.view.*

class BlogAdapter(private val blogListItems: MutableList<Blog>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    override fun getItemCount() = this.blogListItems.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder = BlogViewHolder(
        LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_blog_list, parent, false)
    )

    internal fun addBlogsToList(blogs: List<Blog>) {
        this.blogListItems.addAll(blogs)
        notifyDataSetChanged()
    }

    inner class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
            itemView.contentTextView.text = ""
        }

        fun onBind(position: Int) {

            val (title, coverPageUrl, date, description, author, blogUrl) = blogListItems[position]

            inflateData(title, author, date, description, coverPageUrl)
            setItemClickListener(blogUrl)
        }

        private fun setItemClickListener(blogUrl: String?) {
            itemView.setOnClickListener {
                blogUrl?.let {
                    try {
                        val intent = Intent()
                        // using "with" as an example
                        with(intent) {
                            action = Intent.ACTION_VIEW
                            data = Uri.parse(it)
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        }
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {
                    }
                }

            }
        }

        private fun inflateData(
            title: String?,
            author: String?,
            date: String?,
            description: String?,
            coverPageUrl: String?
        ) {
            title?.let { itemView.titleTextView.text = it }
            author?.let { itemView.authorTextView.text = it }
            date?.let { itemView.dateTextView.text = it }
            description?.let { itemView.contentTextView.text = it }
            coverPageUrl?.let {
                //itemView.coverImageView.loadImage(it)
            }
        }

    }
}