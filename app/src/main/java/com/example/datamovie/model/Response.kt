package com.example.datamovie.model

import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("page"          ) var page         : Int?               = null
    @SerializedName("results"       ) var results      : ArrayList<Results> = arrayListOf()
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null
    @SerializedName("total_results" ) var totalResults : Int?               = null
}