package com.example.dmsassignment.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.dmsassignment.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        github_webview.webViewClient= WebViewClient()
        val webViewSettings = github_webview.settings
        webViewSettings.javaScriptEnabled = true

        github_webview.loadUrl(intent.getStringExtra("url"))
    }
}
