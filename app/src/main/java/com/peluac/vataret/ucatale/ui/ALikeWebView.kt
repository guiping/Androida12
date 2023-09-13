package com.peluac.vataret.ucatale.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class ALikeWebView:Activity() {
    var jumpUrl = ""
    var webview_af: WebView? = null
    private var context: Context? = null

    @SuppressLint("JavascriptInterface", "HandlerLeak")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webview_af = WebView(this)
        setContentView(webview_af)
        val bundle = intent.extras
        if (null != bundle) {
            jumpUrl = bundle.getString("jumpUrl").toString()
        }
        context = this
        if (jumpUrl.isEmpty()) finish()
        webview_af?.webViewClient = WebViewClient()

        webview_af?.webChromeClient = WebChromeClient()
        val webSettings: WebSettings? = webview_af?.settings
        webSettings?.domStorageEnabled = true
        webSettings?.blockNetworkImage = false
        webSettings?.defaultTextEncodingName = "UTF-8"
        webSettings?.useWideViewPort = true
        webSettings?.loadWithOverviewMode = true
        webSettings?.javaScriptEnabled = true

        webSettings?.javaScriptCanOpenWindowsAutomatically = false
        webview_af?.addJavascriptInterface(this, "android")
        webview_af?.loadUrl(jumpUrl)
    }
}