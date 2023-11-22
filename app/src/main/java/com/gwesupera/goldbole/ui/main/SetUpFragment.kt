package com.gwesupera.goldbole.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gwesupera.goldbole.MainActivity
import com.gwesupera.goldbole.databinding.FragmentSetUpBinding
import com.gwesupera.goldbole.ui.ALikeWebView

class SetUpFragment : Fragment() {
    val binding: FragmentSetUpBinding by lazy {
        FragmentSetUpBinding.inflate(layoutInflater)
    }

    companion object {
        fun newInstance() = SetUpFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initView()
        initData()
        return binding.root
    }

    private fun initView() {
        binding.run {
            imgBack.setOnClickListener {  //页面回退
                (activity as MainActivity).switchHomeFragment()
            }
            flFeedback.setOnClickListener {
                val email = Intent(Intent.ACTION_SEND)
                email.type = "application/octet-stream"
                val emailReciver = arrayOf<String>("jordenehumols@hotmail.com")
                email.putExtra(Intent.EXTRA_EMAIL, emailReciver)
                activity?.startActivity(
                    Intent.createChooser(
                        email,
                        "Please choose you client to send!"
                    ).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK
                    )
                )
            }
            flTermof.setOnClickListener {
                startWebView("https://coupavatar.github.io/newavatar/privacypolicy.html")
            }

        }

    }

    fun startWebView(url: String) {
        val intent: Intent = Intent(activity, ALikeWebView::class.java)
        intent.putExtra("jumpUrl", url)
        startActivity(intent)

    }

    private fun initData() {

    }


}