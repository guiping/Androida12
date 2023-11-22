package com.gwesupera.goldbole.ui.main

import androidx.lifecycle.ViewModel
import com.gwesupera.goldbole.R

class SelBoyAvatarViewModel: ViewModel() {
    val sportyAvatarList = listOf(
        R.mipmap.s1,
        R.mipmap.s2,
        R.mipmap.s3,
        R.mipmap.s4,
        R.mipmap.s5
    )
    val handsomeAvatarList = listOf(
        R.mipmap.handsome1,
        R.mipmap.handsome2,
        R.mipmap.handsome3,
        R.mipmap.handsome4,
        R.mipmap.handsome5
    )
    val coolBoyAvatarList = listOf(
        R.mipmap.coolboy1,
        R.mipmap.coolboy2,
        R.mipmap.coolboy3,
        R.mipmap.coolboy4,
        R.mipmap.coolboy5
    )
    val youngBoyAvatarList = listOf(
        R.mipmap.nqn1,
        R.mipmap.nqn2,
        R.mipmap.nqn3,
        R.mipmap.nqn4,
        R.mipmap.nqn5
    )
    fun getAvatar(type:Int):Int?{

        return 0
    }
}