package com.practice.implementretrofitbasicauthentication.data.repository

import com.practice.implementretrofitbasicauthentication.data.api.ApiHelper

class MainRepository (private val apiHelper: ApiHelper){

    suspend fun getUsers() = apiHelper.getUsers()


}