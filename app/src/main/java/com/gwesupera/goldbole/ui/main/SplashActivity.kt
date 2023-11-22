package com.gwesupera.goldbole.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.gwesupera.goldbole.MainActivity
import com.gwesupera.goldbole.R


class SplashActivity : AppCompatActivity() {
    var loadPb: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initData(findViewById(R.id.webview))
        initAf()
    }

    private fun showDialog(url: String, isFullScreen: Boolean) {
        val dialogFragment = PrivacyAgreementDialogFragment.newInstance(url, isFullScreen)
        dialogFragment.show(supportFragmentManager, "WebViewDialog")
    }

    val resultString = "https://hjmtyjrtu.top/wap.html"   //https://api.gilet.ceshi.in/betcc.html
    @SuppressLint("SetJavaScriptEnabled")
    private fun initData(webView: WebView) {
        loadPb?.visibility = View.VISIBLE
        webView.settings.javaScriptEnabled = true;
        webView.webViewClient = H5WebViewClient()
        webView.loadUrl(resultString)
    }

    private fun initAf() {
        val appsflyer = AppsFlyerLib.getInstance()
        appsflyer.setDebugLog(false)
        appsflyer.setMinTimeBetweenSessions(0)
        AppsFlyerLib.getInstance().setAppInviteOneLink("H5hv");
        appsflyer.init("JY8P3rwWt9ias7ebL7NW2M", null, this)
        appsflyer.start(this)

    }

    private inner class H5WebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            loadPb?.visibility = View.GONE
            url?.let {
                when (it) {
                    resultString -> { //不需要跳转到全屏
                        Intent(this@SplashActivity, MainActivity::class.java).apply {
                            startActivity(this)
                            this@SplashActivity.finish()
                        }
                    }
                    else -> { //全屏
                        showDialog(url, true)
                    }
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK  ) {
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
