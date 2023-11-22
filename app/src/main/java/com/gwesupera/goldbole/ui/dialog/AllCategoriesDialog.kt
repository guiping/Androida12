package com.gwesupera.goldbole.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.gwesupera.goldbole.AvatarType
import com.gwesupera.goldbole.databinding.DialogBottomAllCategoriesBinding
import com.gwesupera.goldbole.imp.ItemAvatarClickListener

class AllCategoriesDialog : BottomSheetDialogFragment() {
    var binding: DialogBottomAllCategoriesBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogBottomAllCategoriesBinding.inflate(inflater, container, false)
        initView()
        return binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialog)
    }

    private fun initView() {
        binding?.run {
            imgClose.setOnClickListener {
                dismissAllowingStateLoss()
            }
            llCartoon.setOnClickListener {
                itemClickListener?.itemClickListener(AvatarType.CARTOON)
                dismissAllowingStateLoss()
            }
            llClassy.setOnClickListener {
                itemClickListener?.itemClickListener(AvatarType.CLASSY)
                dismissAllowingStateLoss()
            }
            llYouth.setOnClickListener {
                itemClickListener?.itemClickListener(AvatarType.YOUTH)
                dismissAllowingStateLoss()
            }
            llCool.setOnClickListener {
                itemClickListener?.itemClickListener(AvatarType.COOL)
                dismissAllowingStateLoss()
            }
            llLively.setOnClickListener {
                itemClickListener?.itemClickListener(AvatarType.LIVELY)
                dismissAllowingStateLoss()
            }
        }
    }

    var itemClickListener: ItemAvatarClickListener? = null
    fun setItemClickCallback(itemAvatarClickListener: ItemAvatarClickListener) {
        itemClickListener = itemAvatarClickListener
    }
}