package com.example.dmsassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.adapter.FollowersAdapter
import com.example.dmsassignment.adapter.RepositoryAdapter
import com.example.dmsassignment.data.FollowersInfo
import com.example.dmsassignment.data.RepositoryInfo
import kotlinx.android.synthetic.main.activity_followers.*
import kotlinx.android.synthetic.main.activity_repository.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersActivity : AppCompatActivity() {
    var list = mutableListOf<FollowersInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers)

        val followersAdapter= FollowersAdapter(this,list)
        followers_recyclerview.layoutManager= LinearLayoutManager(this)
        followers_recyclerview.adapter=followersAdapter
        val call = GithubApi().service.getUserFollowersInfo(intent.getStringExtra("id")!!.toString())
        call.enqueue(object : Callback<List<FollowersInfo>> {
            override fun onFailure(call: Call<List<FollowersInfo>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<FollowersInfo>>,
                response: Response<List<FollowersInfo>>
            ) {
                if(response.code()==200){
                    for( i in response.body()!!.size-1 downTo 0){
                        list.add(response.body()!![i])
                    }
                    followersAdapter.notifyDataSetChanged()

                }

            }

        })
    }
}
