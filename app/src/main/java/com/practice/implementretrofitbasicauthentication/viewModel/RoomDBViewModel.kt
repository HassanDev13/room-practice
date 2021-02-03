package com.practice.implementretrofitbasicauthentication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.implementretrofitbasicauthentication.db.DatabaseHelper
import com.practice.implementretrofitbasicauthentication.model.User
import kotlinx.coroutines.launch

class RoomDBViewModel( private val dbHelper: DatabaseHelper) :
    ViewModel() {
    val result = MutableLiveData<List<User>>()
    init {
        fetchUsers()
    }

    private fun fetchUsers() : MutableLiveData<List<User>>{

        viewModelScope.launch {
            try {
                val usersFromDb = dbHelper.getUsers()

                // here you have your usersFromDb
                result.postValue(usersFromDb)

            } catch (e: Exception) {
                // handler error
            }
        }
        return result
    }
    private fun IsertUsers(users : List<User>) {

        viewModelScope.launch {
            try {
                dbHelper.insertAll(users)


            } catch (e: Exception) {
                // handler error
            }
        }
    }

}