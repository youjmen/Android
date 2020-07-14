package com.example.dmsassignment.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import com.example.dmsassignment.data.UserInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val username = intent.getStringExtra("id") ?: UtilClass.getId(applicationContext)


        val call = GithubApi().service.getUserInfo(username)

        loadInfo(call)

        text_repositories_list.setOnClickListener {
            val repoIntent = Intent(this, RepositoryActivity::class.java)
            repoIntent.putExtra("id",UtilClass.getId(applicationContext))
            startActivity(repoIntent)

        }

        text_stars_list.setOnClickListener {
            val starsIntent = Intent(this, StarsActivity::class.java)
            starsIntent.putExtra("id",UtilClass.getId(applicationContext))

            startActivity(starsIntent)

        }

        text_followers_list.setOnClickListener {
            val followersIntent = Intent(this, FollowersActivity::class.java)
            followersIntent.putExtra("id",UtilClass.getId(applicationContext))

            startActivity(followersIntent)


        }

        text_following_list.setOnClickListener {
            val followingIntent = Intent(this, FollowingActivity::class.java)
            followingIntent.putExtra("id",UtilClass.getId(applicationContext))

            startActivity(followingIntent)


        }
        change_username_button.setOnClickListener {
          showChangeUsernameDialog()


        }








    }
    fun showChangeUsernameDialog() {
        val dialog = ChangeUsernameDialogFragment()
        dialog.show(supportFragmentManager, "ChangeUsernameDialogFragment")
    }
    fun loadInfo(call : Call<UserInfo>){
        call.enqueue(object : Callback<UserInfo> {
            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                t.printStackTrace()


            }

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                if(response.code()==200){
                    Log.d("성공","success")

                    text_name.text = response.body()?.name ?: ""
                    text_id.text = response.body()?.id
                    text_blog.text = response.body()?.blog
                    text_followers.text = response.body()?.followers.toString() + " followers"

                    text_following.text = response.body()?.following.toString() + " following"

                    text_bio.text = response.body()?.bio
                    text_company.text = response.body()?.company
                    text_email.text = response.body()?.email
                    text_location.text ="지역"+ response.body()?.location
                    repositories_count.text = response.body()?.publicRepos.toString()

                    followers_count.text = response.body()?.followers.toString()

                    following_count.text = response.body()?.following.toString()
                    Glide.with(this@UserActivity)
                        .load(response.body()?.avatar_url.toString())
                        .into(profile_image)






                }
                else{
                    Log.d("failled :",response.code().toString())
                }

            }

        })


    }




}
