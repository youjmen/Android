package com.example.dmsassignment.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dmsassignment.R
import com.example.dmsassignment.data.FollowingInfo
import com.example.dmsassignment.view.Fragment.WebViewFragment
import kotlinx.android.synthetic.main.following_item.view.*

class FollowingAdapter(private val context : Context, private val list: List<FollowingInfo>) : RecyclerView.Adapter<FollowingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.following_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size

    }



    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        private var view = v
        fun bind(item : FollowingInfo){

            view.following_name.text =item.id
            Glide.with(context)
                .load(item.avatar_url)
                .into(view.following_profile_image)




        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            val bundle= Bundle()
            bundle.putString("url",list[position].html_url)
            val fragment = WebViewFragment()
            fragment.arguments=bundle
            val transaction =(context as FragmentActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_layout, fragment)
            transaction.addToBackStack(null)

            transaction.commit()

        }



    }
}