package com.zasa.worldnews

import com.zasa.newsapp.response.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 **@Project -> NewsApp
 **@Author -> Sangeeth on 9/15/2022
 */
interface NewsApi {

    @GET("top-headlines")
    fun getTopHeadlineds(
        @Query("apiKey") apiKey : String,
        @Query("country") country : String
    ) : Call<NewsData>

    @GET("everything")
    fun getSearchNews(
        @Query("q") q : String,
        @Query("apiKey") apiKey : String
    ) : Call<NewsData>

}