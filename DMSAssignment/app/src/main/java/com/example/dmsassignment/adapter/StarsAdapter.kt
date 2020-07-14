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
import com.example.dmsassignment.data.StarsInfo
import com.example.dmsassignment.view.Fragment.WebViewFragment
import kotlinx.android.synthetic.main.stars_item.view.*

class StarsAdapter(private val context : Context, private val list: List<StarsInfo>) : RecyclerView.Adapter<StarsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stars_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size

    }



    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        private var view = v
        fun bind(item : StarsInfo){

            view.starred_owner_name.text =item.owner.login
            view.starred_repositories_name.text=item.name
            view.starred_repositories_description.text=item.description
            view.starred_repositories_language.text=item.language
            view.starred_repositories_stargazers_count.text=item.stargazers_count.toString()

            Glide.with(context)
                .load(item.owner.avatar_url)
                .into(view.starred_owner_profile_image)


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