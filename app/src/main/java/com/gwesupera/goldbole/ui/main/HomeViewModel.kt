package com.gwesupera.goldbole.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gwesupera.goldbole.AvatarType
import com.gwesupera.goldbole.R
import com.gwesupera.goldbole.model.HomeItemModel

class HomeViewModel : ViewModel() {
    val titleList = listOf(
        R.string.home_cartoon,
        R.string.home_classy,
        R.string.home_youth,
        R.string.home_cool,
        R.string.home_lively
    )
    val avatarList = listOf(
        R.mipmap.k1,
        R.mipmap.qz1_h_d,
        R.mipmap.nq1_h_d,
        R.mipmap.c1_h_d,
        R.mipmap.h1_h_d
    )
    val homeItemList: MutableLiveData<ArrayList<HomeItemModel>> = MutableLiveData()

    fun getAvatarData(context: Context) {
        val list = ArrayList<HomeItemModel>()
        for ((index, item) in titleList.withIndex()) {
            var type = AvatarType.CARTOON
            when (index) {
                0 -> {
                    type = AvatarType.CARTOON
                }
                1 -> {
                    type = AvatarType.CLASSY
                }
                2 -> {
                    type = AvatarType.YOUTH
                }
                3 -> {
                    type = AvatarType.COOL
                }
                4 -> {
                    type = AvatarType.LIVELY
                }
            }
            val homeItemModel = HomeItemModel(avatarList[index], context.getString(item), type)
            list.add(homeItemModel)
        }
        homeItemList.value = list
    }
}