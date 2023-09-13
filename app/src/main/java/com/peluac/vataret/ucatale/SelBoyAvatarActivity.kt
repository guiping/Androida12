package com.peluac.vataret.ucatale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.ui.main.SelBoyAvatarFragment

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