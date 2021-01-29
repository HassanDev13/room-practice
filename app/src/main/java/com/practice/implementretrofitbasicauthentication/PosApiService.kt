package com.practice.implementretrofitbasicauthentication

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PosApiService {
    private val BASE_URL = "https://api.demo.com"

    //add BasicAuthInterceptor to OkHttp client
    val client = OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor("", "123"))
        .build()

    val gson = GsonBuilder()
        .setLenient()
        .create();
    // add OkHttp client to Retrofit instance
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PosApi::class.java)

    fun sendAmount(amount: Double, msisdn: String):  Single<PosResponse>{
        return api.sendAmount(amount, msisdn)
    }

}
