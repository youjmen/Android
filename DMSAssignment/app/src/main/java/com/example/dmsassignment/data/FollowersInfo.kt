package com.example.dmsassignment.data

import com.google.gson.annotations.SerializedName

class FollowersInfo {
    @SerializedName("login")
    lateinit var id: String

    @SerializedName("avatar_url")
    lateinit var avatar_url: String
    @SerializedName("html_url")
    lateinit var html_url: String



}