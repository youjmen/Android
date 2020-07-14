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
import com.example.dmsassignment.adapter.FollowingAdapter
import com.example.dmsassignment.data.FollowingInfo
import kotlinx.android.synthetic.main.fragment_following.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FollowingFragment : Fragment() {
    var list = mutableListOf<FollowingInfo>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_following, container, false)

        val followingAdapter= FollowingAdapter(requireActivity(),list)
        view.following_recyclerview.layoutManager= LinearLayoutManager(requireActivity())
        view.following_recyclerview.adapter=followingAdapter
        val call = GithubApi().service.getUserFollowingInfo(UtilClass.getId(requireActivity().applicationContext))

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
        return view
    }

}
