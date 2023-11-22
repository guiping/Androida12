package com.gwesupera.goldbole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gwesupera.goldbole.ui.main.SelBoyAvatarFragment

class SelBoyAvatarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SelBoyAvatarFragment.newInstance())
                .commitNow()
        }
    }

    fun closeActivity() {
        this.finish()
    }
}