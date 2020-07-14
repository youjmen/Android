package com.example.dmsassignment.view.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import com.example.dmsassignment.adapter.StarsAdapter
import com.example.dmsassignment.data.StarsInfo
import kotlinx.android.synthetic.main.fragment_stars.view.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StarsFragment : Fragment() {

    var list = mutableListOf<StarsInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_stars, container, false)
        val starsAdapter= StarsAdapter(requireActivity(),list)
        view.stars_recyclerview.layoutManager= LinearLayoutManager(requireActivity())
        view.stars_recyclerview.adapter=starsAdapter
        val call = GithubApi().service.getUserStarsInfo(UtilClass.getId(requireActivity().applicationContext))
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

        return view
    }


}