package com.example.githubapikotlin.entity

import com.google.gson.annotations.SerializedName

class Resource {
    @SerializedName("login")
    lateinit var userId:String

    @SerializedName("name")
    lateinit var userName:String

    @SerializedName("followers")
    lateinit var userFollowers:String

    @SerializedName("following")
    lateinit var userFollowing:String
}