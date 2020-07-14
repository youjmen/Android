package com.example.dmsassignment.view.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.dmsassignment.R
import kotlinx.android.synthetic.main.fragment_web_view.view.*


class WebViewFragment : Fragment() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web_view, container, false)
        view.github_webview.webViewClient= WebViewClient()
        val webViewSettings = view.github_webview.settings
        webViewSettings.javaScriptEnabled = true

        view.github_webview.loadUrl(arguments!!.getString("url"))
        return view
    }


}