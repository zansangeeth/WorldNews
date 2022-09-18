package com.zasa.worldnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zasa.newsapp.response.Article
import kotlinx.android.synthetic.main.item_top_headlines.view.*

/**
 * Created by Sangeeth Amirthanathan
 * on 9/18/2022.
 */
class TopNewsAdapter(val context: Context, val topNewsList: List<Article>) : RecyclerView.Adapter<TopNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_top_headlines, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val topNews = topNewsList[position]
        holder.bind(topNews)
    }

    override fun getItemCount() = topNewsList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(topNews: Article) {
            Glide.with(context).load(topNews.urlToImage).into(itemView.ivBreakingNes)
            itemView.tvUsername.text = topNews.author
            itemView.tvHeadline.text = topNews.title
            itemView.tvPublishedAt.text = topNews.publishedAt
        }

    }
}