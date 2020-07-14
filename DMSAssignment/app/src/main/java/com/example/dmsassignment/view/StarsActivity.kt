package com.example.dmsassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.adapter.RepositoryAdapter
import com.example.dmsassignment.adapter.StarsAdapter
import com.example.dmsassignment.data.RepositoryInfo
import com.example.dmsassignment.data.StarsInfo
import kotlinx.android.synthetic.main.activity_repository.*
import kotlinx.android.synthetic.main.activity_stars.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarsActivity : AppCompatActivity() {
    var list = mutableListOf<StarsInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stars)

        val starsAdapter= StarsAdapter(this,list)
        stars_recyclerview.layoutManager= LinearLayoutManager(this)
        stars_recyclerview.adapter=starsAdapter
        val call = GithubApi().service.getUserStarsInfo(intent.getStringExtra("id")!!.toString())
        call.enqueue(object : Callback<List<StarsInfo>> {
            override fun onFailure(call: Call<List<StarsInfo>>, t: Throwable) {
                t.printStackTrace()

            }

            override fun onResponse(
                call: Call<List<StarsInfo>>,
                response: Response<List<StarsInfo>>
            ) {
                if(response.code()==200){
                    for( i in response.body()!!.size-1 downTo 0){
                        list.add(response.body()!![i])
                    }
                    starsAdapter.notifyDataSetChanged()

                }
                else{
                    Log.d("failed : ",response.code().toString())
                }

            }

        })
    }
}
