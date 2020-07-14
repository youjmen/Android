package com.example.dmsassignment.data

import com.google.gson.annotations.SerializedName

class StarsInfo {
    @SerializedName("name")
    lateinit var name : String
    @SerializedName("owner")
    lateinit var owner : StarredRepositoryOwner
    @SerializedName("html_url")
    lateinit var html_url : String
    @SerializedName("description")
    var description : String = ""
    @SerializedName("language")
    var language : String = ""
    @SerializedName("stargazers_count")
    var stargazers_count : Int =0

}