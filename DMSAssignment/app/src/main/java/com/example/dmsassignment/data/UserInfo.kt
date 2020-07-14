package com.example.dmsassignment.data

import com.google.gson.annotations.SerializedName

class UserInfo {
    @SerializedName("login")
    lateinit var id: String

    @SerializedName("avatar_url")
    lateinit var avatar_url: String
    @SerializedName("name")
    var name: String =""

    @SerializedName("blog")
    var blog: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("bio")
    var bio: String = ""

    @SerializedName("location")
    var location: String = ""

    @SerializedName("company")
    var company: String = ""

    @SerializedName("followers")
    var followers: Int =0

    @SerializedName("following")
    var following: Int =0

    @SerializedName("public_repos")
    var publicRepos: Int =0




}