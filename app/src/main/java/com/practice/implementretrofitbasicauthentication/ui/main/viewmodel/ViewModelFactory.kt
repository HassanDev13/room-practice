package com.practice.implementretrofitbasicauthentication.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.implementretrofitbasicauthentication.data.api.ApiHelper
import com.practice.implementretrofitbasicauthentication.data.repository.MainRepository

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}