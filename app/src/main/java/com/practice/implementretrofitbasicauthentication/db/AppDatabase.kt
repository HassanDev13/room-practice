package com.practice.implementretrofitbasicauthentication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practice.implementretrofitbasicauthentication.model.User
import com.practice.implementretrofitbasicauthentication.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}