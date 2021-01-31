package com.practice.implementretrofitbasicauthentication.service

import com.practice.implementretrofitbasicauthentication.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface redditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String)
            : Call<RedditNewsResponse>;
}