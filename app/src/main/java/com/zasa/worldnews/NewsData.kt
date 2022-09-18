package com.zasa.newsapp.response

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)