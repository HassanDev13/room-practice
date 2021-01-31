package com.practice.implementretrofitbasicauthentication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.implementretrofitbasicauthentication.R
import com.practice.implementretrofitbasicauthentication.data.api.ApiHelper
import com.practice.implementretrofitbasicauthentication.data.api.RetrofitBuilder
import com.practice.implementretrofitbasicauthentication.data.model.User
import com.practice.implementretrofitbasicauthentication.ui.main.adapter.MainAdapter
import com.practice.implementretrofitbasicauthentication.ui.main.viewmodel.MainViewModel
import com.practice.implementretrofitbasicauthentication.ui.main.viewmodel.ViewModelFactory
import com.practice.implementretrofitbasicauthentication.utils.Status
import timber.log.Timber

private lateinit var viewModel: MainViewModel
private lateinit var adapter: MainAdapter
private lateinit var recyclerView : RecyclerView
private lateinit var progressBar: ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUI()
        setupObservers()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<User>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}