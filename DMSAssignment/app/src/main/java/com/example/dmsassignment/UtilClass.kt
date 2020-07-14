package com.example.dmsassignment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log

class UtilClass {
    companion object {
        var pref: SharedPreferences? = null





        fun getId(context: Context): String {
            pref = context.getSharedPreferences("DMSAssignment", MODE_PRIVATE)
            return pref?.getString("id", "default")!!
        }

        fun saveId(context: Context, username: String) {
            pref = context.getSharedPreferences("DMSAssignment", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref!!.edit()
            editor.putString("id", username)
            editor.apply()
        }
        fun changeId(context: Context, username: String) {
            pref = context.getSharedPreferences("DMSAssignment", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref!!.edit()
            editor.putString("id", username)
            editor.apply()
        }
    }

}