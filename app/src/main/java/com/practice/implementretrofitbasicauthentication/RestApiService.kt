package com.practice.implementretrofitbasicauthentication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUser(userData: UserInfoModel, onResult: (UserInfoModel?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<UserInfoModel> {
                override fun onFailure(call: Call<UserInfoModel>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<UserInfoModel>, response: Response<UserInfoModel>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}
