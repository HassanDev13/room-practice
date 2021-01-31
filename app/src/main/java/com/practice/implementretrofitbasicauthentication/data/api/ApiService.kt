package com.practice.implementretrofitbasicauthentication.data.api

import com.practice.implementretrofitbasicauthentication.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}