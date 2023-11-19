package com.peluac.vataret.ucatale.ui.main

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.DialogFragment
import com.peluac.vataret.ucatale.R
import org.json.JSONException
import org.json.JSONObject


class PrivacyAgreementDialogFragment : DialogFragment() {
    companion object {
        private const val ARG_URL = "ARG_URL"
        private const val ARG_FULL_SCREEN = "ARG_FULL_SCREEN"

        fun newInstance(url: String, isFullScreen: Boolean): PrivacyAgreementDialogFragment {
            val args = Bundle()
            args.putString(ARG_URL, url)
            args.putBoolean(ARG_FULL_SCREEN, isFullScreen)

            val fragment = PrivacyAgreementDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var webView: WebView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_privacy_agreement, null)
        webView = view.findViewById(R.id.wb_load_privacy_agreement)
        setupWebView()

        val dialog = Dialog(requireContext(), R.style.FullScreenDialogStyle)
        dialog.setContentView(view)

        val window = dialog.window
        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        loadWebPage()
        return dialog
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        webView.stopLoading()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.domStorageEnabled = true
        webView.settings.setSupportMultipleWindows(true)
        webView.isHorizontalScrollBarEnabled = false
        webView.isVerticalScrollBarEnabled = false
        webView.webViewClient = WebViewClient()
//        webView.addJavascriptInterface(XXXJsAndroid(activity), "Android")
        webView.addJavascriptInterface(XXCallJava(requireActivity()), "android")
        webView.webChromeClient = ChromeClients(requireActivity(), webView, 1)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
    }

    lateinit var url: String
    private fun loadWebPage() {
        url = arguments?.getString(ARG_URL).toString()
        val isFullScreen = arguments?.getBoolean(ARG_FULL_SCREEN)
        Log.e("pLog", " ---- $url -------isFullScreen = $isFullScreen")
        if (url != null)
            webView.loadUrl(url)
    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK && webView?.canGoBack() == true) {
//            webView?.goBack()
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }

}