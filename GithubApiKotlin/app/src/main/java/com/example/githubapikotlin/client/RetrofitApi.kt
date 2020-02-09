package com.example.githubapikotlin.client

import com.example.githubapikotlin.entity.Resource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {
    @GET("/users/{user}")
    fun getUserInfo(@Path("user") user:String): Call<Resource>
}