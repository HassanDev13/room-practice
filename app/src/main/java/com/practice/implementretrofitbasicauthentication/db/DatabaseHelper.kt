package com.practice.implementretrofitbasicauthentication.db

import com.practice.implementretrofitbasicauthentication.model.User

interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)

}