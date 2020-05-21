package com.example.lifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("[onCreate]","main")

        button.setOnClickListener {
            val intent = Intent(this,subActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("[onStart]","main")
    }
    override fun onPause() {
        super.onPause()
        Log.d("[onPause]","main")
    }
    override fun onResume() {
        super.onResume()
        Log.d("[onResume]", "main")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("[onRestart]","main")
    }

    override fun onStop() {
        super.onStop()
        Log.d("[onStop]","main")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("[onDestroy]","main")

    }

}
