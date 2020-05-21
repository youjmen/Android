package com.example.lifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class subActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Log.d("[onCreate]","sub")
    }

    override fun onStart() {
        super.onStart()
        Log.d("[onStart]", "sub")
    }

    override fun onPause() {
        super.onPause()
        Log.d("[onPause]", "sub")
    }
    override fun onResume() {
        super.onResume()
        Log.d("[onResume]", "sub")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("[onRestart]", "sub")
    }

    override fun onStop() {
        super.onStop()
        Log.d("[onStop]", "sub")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("[onDestroy]", "sub")


    }
}
