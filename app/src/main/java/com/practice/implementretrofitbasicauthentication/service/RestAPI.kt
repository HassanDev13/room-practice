package com.practice.implementretrofitbasicauthentication.service

import com.practice.implementretrofitbasicauthentication.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RestAPI {
    private val redditApiV: redditApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        redditApiV = retrofit.create(redditApi::class.java)
    }
    fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApiV.getTop(after, limit)
    }
}