package com.example.githubapikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.githubapikotlin.client.GithubApi
import com.example.githubapikotlin.client.RetrofitApi
import com.example.githubapikotlin.entity.Resource
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        confirm_button.setOnClickListener {
            val id: String = inputID.text.toString()
            val githubApi: Call<Resource> = GithubApi().service.getUserInfo(id)
            githubApi.enqueue(object : Callback<Resource> {
                override fun onFailure(call: Call<Resource>, t: Throwable) {
                    Log.e("ERR : ", t.message.toString())
                }

                override fun onResponse(call: Call<Resource>, response: Response<Resource>) {
                    textView.setText(response.body()?.userId)
                    textView2.setText(response.body()?.userName)
                    textView3.setText(response.body()?.userFollowers)
                    textView4.setText(response.body()?.userFollowing)

                }
            })
        }
    }
}
