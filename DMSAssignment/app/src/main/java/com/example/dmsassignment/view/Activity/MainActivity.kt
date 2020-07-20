package com.example.dmsassignment.view.Activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.dmsassignment.R
import com.example.dmsassignment.view.Fragment.FirstRegisterFragment


class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_layout, FirstRegisterFragment())
        transaction.commit()



    }

}
