package com.example.datamovie.rest

import com.example.datamovie.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/3/movie/{category}")
    fun getMovie(
        @Path("category") category: String,
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<Response>

    @GET("/3/search/movie")
    fun getQuery(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: Int
    ): Call<Response>
}