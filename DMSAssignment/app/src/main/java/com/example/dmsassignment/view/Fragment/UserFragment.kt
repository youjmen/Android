package com.example.dmsassignment.view.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import com.example.dmsassignment.data.UserInfo
import io.reactivex.Single


import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_user, container, false)
        val username = UtilClass.getId(requireActivity().applicationContext)


        val call = GithubApi().service.getUserInfo(username)

        loadInfo(call)

        view.text_repositories_list.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_layout, RepositoryFragment())
            transaction.addToBackStack(null)
            transaction.commit()



        }

        view.text_stars_list.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_layout, StarsFragment())
            transaction.addToBackStack(null)
            transaction.commit()


        }

        view.text_followers_list.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_layout,FollowersFragment())
            transaction.addToBackStack(null)
            transaction.commit()



        }

        view.text_following_list.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_layout,FollowingFragment())
            transaction.addToBackStack(null)
            transaction.commit()



        }
        view.change_username_button.setOnClickListener {
            showChangeUsernameDialog()


        }




        return view
    }
    fun showChangeUsernameDialog() {
        val dialog =
            ChangeUsernameDialogFragment()
        dialog.show(requireActivity().supportFragmentManager, "ChangeUsernameDialogFragment")
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
                    Glide.with(requireActivity())
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