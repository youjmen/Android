package com.example.dmsassignment

import com.example.dmsassignment.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user_id}")
    fun getUserInfo(@Path("user_id") username : String) : Call<UserInfo>

    @GET("users/{user_id}/repos")
    fun getUserRepoInfo(@Path("user_id") username : String) : Call<List<RepositoryInfo>>

    @GET("users/{user_id}/starred")
    fun getUserStarsInfo(@Path("user_id") username : String) : Call<List<StarsInfo>>

    @GET("users/{user_id}/followers")
    fun getUserFollowersInfo(@Path("user_id") username : String) : Call<List<FollowersInfo>>

    @GET("users/{user_id}/following")
    fun getUserFollowingInfo(@Path("user_id") username : String) : Call<List<FollowingInfo>>
}