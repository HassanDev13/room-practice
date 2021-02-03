package com.practice.implementretrofitbasicauthentication.db

import com.practice.implementretrofitbasicauthentication.model.User

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {


    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)

}