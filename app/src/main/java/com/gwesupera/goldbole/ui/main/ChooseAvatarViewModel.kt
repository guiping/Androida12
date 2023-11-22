package com.gwesupera.goldbole.ui.main

import androidx.lifecycle.ViewModel
import com.gwesupera.goldbole.AvatarType
import com.gwesupera.goldbole.R

class ChooseAvatarViewModel: ViewModel() {
    private val avatarMap:HashMap<Int,Int> = HashMap()
    init {
        avatarMap[AvatarType.CARTOON] = R.mipmap.k2_h_d
        avatarMap[AvatarType.CLASSY] = R.mipmap.qz1_h_d
        avatarMap[AvatarType.YOUTH] = R.mipmap.nq1_h_d
        avatarMap[AvatarType.COOL] = R.mipmap.c1_h_d
        avatarMap[AvatarType.LIVELY] = R.mipmap.h1_h_d
    }


    val avatarCartoonList = listOf(
        R.mipmap.k1,
        R.mipmap.k2,
        R.mipmap.k3,
        R.mipmap.k4,
        R.mipmap.k5
    )
    val avatarClassList = listOf(
        R.mipmap.qz1,
        R.mipmap.qz2,
        R.mipmap.qz3,
        R.mipmap.qz4,
        R.mipmap.qz5
    )
    val avatarYouthList = listOf(
        R.mipmap.nq1,
        R.mipmap.nq2,
        R.mipmap.nq3,
        R.mipmap.nq4,
        R.mipmap.nq5
    )
    val avatarCoolList = listOf(
        R.mipmap.c1,
        R.mipmap.c2,
        R.mipmap.c3,
        R.mipmap.c4,
        R.mipmap.c5
    )
    val avatarLivelyList = listOf(
        R.mipmap.h1,
        R.mipmap.h2,
        R.mipmap.h3,
        R.mipmap.h4,
        R.mipmap.h5
    )
    fun getAvatar(type:Int):Int?{
        return avatarMap[type]
    }
}