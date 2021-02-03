package com.practice.implementretrofitbasicauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.implementretrofitbasicauthentication.db.DatabaseBuilder
import com.practice.implementretrofitbasicauthentication.db.DatabaseHelperImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create the instance of DatabaseHelper
        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))



    }




}