package com.example.dmsassignment

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubApi {
    private fun makeInterceptor() : OkHttpClient{
        val okHttpInterceptor=HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Log.d("Requset : ",message)
            }
        })
        okHttpInterceptor.level=HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder().addInterceptor(okHttpInterceptor).build()
    }


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(makeInterceptor())
        .build()

    val service = retrofit.create(GithubService::class.java)
}