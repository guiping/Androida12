package com.peluac.vataret.ucatale.ui.main

import androidx.lifecycle.ViewModel
import com.peluac.vataret.ucatale.AvatarType
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.utils.FilterUtil

class EditAvatarViewModel : ViewModel() {
    private val avatarMap: HashMap<Int, Int> = HashMap()

    init {
        avatarMap[AvatarType.CARTOON] = R.mipmap.k2_h_d
        avatarMap[AvatarType.CLASSY] = R.mipmap.qz1_h_d
        avatarMap[AvatarType.YOUTH] = R.mipmap.nq1_h_d
        avatarMap[AvatarType.COOL] = R.mipmap.c1_h_d
        avatarMap[AvatarType.LIVELY] = R.mipmap.h1_h_d
    }

    val stiker1List = listOf(
        R.mipmap.stiler1_1,
        R.mipmap.stiler1_2,
        R.mipmap.stiler1_3,
        R.mipmap.stiler1_4,
        R.mipmap.stiler1_5
    )

    val stiker2List = listOf(
        R.mipmap.stiler2_1,
        R.mipmap.stiler2_2,
        R.mipmap.stiler2_3,
        R.mipmap.stiler2_4,
        R.mipmap.stiler2_5
    )
    val failter1List = listOf(
        FilterUtil.colormatrix_chuan_tong,
        FilterUtil.colormatrix_huaijiu,
        FilterUtil.colormatrix_gete,
        FilterUtil.colormatrix_danya,
        FilterUtil.colormatrix_landiao
    )
    val failter2List = listOf(
        FilterUtil.colormatrix_guangyun,
        FilterUtil.colormatrix_menghuan,
        FilterUtil.colormatrix_jiuhong,
        FilterUtil.colormatrix_hepian,
        FilterUtil.colormatrix_huguang
    )


    fun getAvatar(type: Int): Int? {
        return avatarMap[type]
    }

}