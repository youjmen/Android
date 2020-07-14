package com.example.dmsassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.adapter.RepositoryAdapter
import com.example.dmsassignment.data.RepositoryInfo
import kotlinx.android.synthetic.main.activity_repository.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryActivity : AppCompatActivity() {
    var list = mutableListOf<RepositoryInfo>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        val repositoryAdapter= RepositoryAdapter(this,list)
        repositories_recyclerview.layoutManager=LinearLayoutManager(this)
        repositories_recyclerview.adapter=repositoryAdapter
        val call = GithubApi().service.getUserRepoInfo(intent.getStringExtra("id")!!.toString())
        call.enqueue(object : Callback<List<RepositoryInfo>> {
            override fun onFailure(call: Call<List<RepositoryInfo>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<RepositoryInfo>>,
                response: Response<List<RepositoryInfo>>
            ) {
                if(response.code()==200){
                    for( i in response.body()!!.size-1 downTo 0){
                        list.add(response.body()!![i])
                    }
                    repositoryAdapter.notifyDataSetChanged()

                }

            }

        })


    }
}
