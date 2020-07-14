package com.example.dmsassignment.data

import com.google.gson.annotations.SerializedName

class RepositoryOwner {
    @SerializedName("login")
    lateinit var login : String
    @SerializedName("avatar_url")
    lateinit var avatar_url : String
}