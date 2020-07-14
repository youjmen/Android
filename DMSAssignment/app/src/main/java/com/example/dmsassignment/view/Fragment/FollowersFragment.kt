package com.example.dmsassignment.view.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import com.example.dmsassignment.adapter.FollowersAdapter
import com.example.dmsassignment.data.FollowersInfo
import kotlinx.android.synthetic.main.fragment_followers.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FollowersFragment : Fragment() {
    var list = mutableListOf<FollowersInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_followers, container, false)
        val followersAdapter= FollowersAdapter(requireActivity(),list)
        view.followers_recyclerview.layoutManager= LinearLayoutManager(requireActivity())
        view.followers_recyclerview.adapter=followersAdapter
        val call = GithubApi().service.getUserFollowersInfo(UtilClass.getId(requireActivity().applicationContext))
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
        return view
    }


}