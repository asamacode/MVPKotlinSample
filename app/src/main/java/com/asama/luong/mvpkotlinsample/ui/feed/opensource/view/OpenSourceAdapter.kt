package com.asama.luong.mvpkotlinsample.ui.feed.opensource.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.asama.luong.mvpkotlinsample.R
import com.asama.luong.mvpkotlinsample.data.network.model.OpenSource
import kotlinx.android.synthetic.main.item_blog_list.view.*

class OpenSourceAdapter(private val openSourceListItems: MutableList<OpenSource>) :
    RecyclerView.Adapter<OpenSourceAdapter.OpenSourceViewHolder>() {

    override fun getItemCount() = this.openSourceListItems.size

    override fun onBindViewHolder(holder: OpenSourceViewHolder, position: Int) = holder.run {
        clear()
        onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenSourceViewHolder = OpenSourceViewHolder(
        LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_open_source_list, parent, false)
    )


    internal fun addOpenSourcesToList(OpenSources: List<OpenSource>) {
        this.openSourceListItems.addAll(OpenSources)
        notifyDataSetChanged()
    }

    inner class OpenSourceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.coverImageView.setImageDrawable(null)
            itemView.titleTextView.text = ""
            itemView.contentTextView.text = ""
        }

        fun onBind(position: Int) {
            val (projectUrl, coverImgUrl, title, description) = openSourceListItems[position]

            inflateData(title, description, coverImgUrl)
            setItemClickListener(projectUrl)
        }

        private fun setItemClickListener(projectUrl: String?) {
            itemView.setOnClickListener {
                projectUrl?.let {
                    try {
                        // using "apply" as an example
                        itemView.context.startActivity(Intent().apply {
                            action = Intent.ACTION_VIEW
                            data = it.toUri()
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        })
                    } catch (e: Exception) {
                    }
                }
            }
        }

        private fun inflateData(title: String?, description: String?, coverImgUrl: String?) {
            title?.let { itemView.titleTextView.text = it }
            description?.let { itemView.contentTextView.text = it }
            coverImgUrl?.let {
//                itemView.coverImageView.loadImage(it)
            }
        }
    }
}