package com.practice.implementretrofitbasicauthentication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
      //  var context: Context = this@MainActivity
      fun addDummyUser() {
          val apiService = RestApiService()
          val userInfo = UserInfoModel(
              userId  = null,
              userName = "Alex",
              userEmail = "alex@gmail.com",
              userAge = "32",
              userUid = "164E92FC-D37A-4946-81CB-29DE7EE4B124" )

          apiService.addUser(userInfo) {
              if (it?.userId != null) {
                  // it = newly added user parsed as response
                  // it?.id = newly added user ID
              } else {
                  Timber.d("Error registering new user")
              }
          }
      }

    }
}