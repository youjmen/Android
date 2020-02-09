package com.example.githubapikotlin.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(RetrofitApi::class.java)

}