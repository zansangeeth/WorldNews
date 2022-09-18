package com.zasa.worldnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zasa.newsapp.response.Article
import com.zasa.newsapp.response.NewsData
import com.zasa.worldnews.Utils.API_KEY
import com.zasa.worldnews.Utils.BASE_URL
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topNewsList = mutableListOf<Article>()
        val topNewsAdapter = TopNewsAdapter(this, topNewsList)

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val retrofitService = retrofit.create(NewsApi::class.java)

        retrofitService.getTopHeadlineds("$API_KEY", "us").enqueue(object :Callback<NewsData>{
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                val body = response.body()
                topNewsList.addAll(body!!.articles)
                rvTopnews.layoutManager = LinearLayoutManager(this@MainActivity)
                rvTopnews.adapter = topNewsAdapter
                topNewsAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}