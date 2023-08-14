package com.example.datamovie.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.datamovie.R
import com.example.datamovie.adapter.MovieAdapter
import com.example.datamovie.model.Response
import com.example.datamovie.rest.ApiClient
import com.example.datamovie.rest.ApiInterface
import com.google.android.material.search.SearchView
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MovieAdapter
    private lateinit var searchView: SearchView
    private val API_KEY = "bcbd15d0dbd5687957e8d2c5be1d0509"
    private val LANGUAGE = "en-US"
    private val CATEGORY = "popular"
    private val PAGE = 1
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvMovie)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        callRetrofit()
    }

    private fun callRetrofit() {
        val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiInterface.getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE)
        call.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful && response.body() != null) {
                    val mList = response.body()?.results
                    if (mList != null) {
                        adapter = MovieAdapter(this@MainActivity, mList)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                // Handle failure case if needed
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}