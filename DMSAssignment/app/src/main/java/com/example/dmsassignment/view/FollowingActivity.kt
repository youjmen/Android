package com.example.dmsassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.adapter.FollowingAdapter
import com.example.dmsassignment.adapter.RepositoryAdapter
import com.example.dmsassignment.data.FollowingInfo
import com.example.dmsassignment.data.RepositoryInfo
import kotlinx.android.synthetic.main.activity_following.*
import kotlinx.android.synthetic.main.activity_repository.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingActivity : AppCompatActivity() {
    var list = mutableListOf<FollowingInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following)

        val followingAdapter= FollowingAdapter(this,list)
        following_recyclerview.layoutManager= LinearLayoutManager(this)
        following_recyclerview.adapter=followingAdapter
        val call = GithubApi().service.getUserFollowingInfo(intent.getStringExtra("id")!!.toString())

        call.enqueue(object : Callback<List<FollowingInfo>> {
            override fun onFailure(call: Call<List<FollowingInfo>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<FollowingInfo>>,
                response: Response<List<FollowingInfo>>
            )
            {
                if(response.code()==200){
                    for( i in response.body()!!.size-1 downTo 0){
                        list.add(response.body()!![i])
                    }
                    followingAdapter.notifyDataSetChanged()

                }

            }

        })
    }

}
