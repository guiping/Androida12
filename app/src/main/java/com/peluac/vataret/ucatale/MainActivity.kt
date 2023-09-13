package com.peluac.vataret.ucatale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appsflyer.AppsFlyerLib
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.ui.main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
        AppsFlyerLib.getInstance().logEvent(applicationContext, "pi_launch", null)
    }

    fun switchChooseAvatar(type: Int) {
        val chooseAvatarFragment = ChooseAvatarFragment.newInstance()
        val bundle = Bundle()
        bundle.putInt("type", type)
        chooseAvatarFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, chooseAvatarFragment)
            .commitAllowingStateLoss()
    }

    fun switchHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance())
            .commitAllowingStateLoss()
    }

    fun switchSetUpFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SetUpFragment.newInstance())
            .commitAllowingStateLoss()
    }

    fun switchEditAvatarFragment(type: Int, avatarId: Int) {
        val editAvatarFragment = EditAvatarFragment.newInstance()
        val bundle = Bundle()
        bundle.putInt("type", type)
        bundle.putInt("avatarId", avatarId)
        editAvatarFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, editAvatarFragment)
            .commitAllowingStateLoss()
    }

    fun switchSelBoyFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SelBoyAvatarFragment.newInstance())
            .commitAllowingStateLoss()
    }
}