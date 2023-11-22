package com.gwesupera.goldbole.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.gwesupera.goldbole.SelBoyAvatarActivity
import com.gwesupera.goldbole.databinding.FragmentSelBoyAvatarBinding
import com.gwesupera.goldbole.observer.ShareDataManager
import com.gwesupera.goldbole.view.SShapeFrameLayout
import com.gwesupera.goldbole.view.SShapeModel

class SelBoyAvatarFragment : Fragment() {
    val binding: FragmentSelBoyAvatarBinding by lazy {
        FragmentSelBoyAvatarBinding.inflate(layoutInflater)
    }
    var curSelShapeModel: SShapeModel? = null
    var curSelLayout: SShapeFrameLayout? = null
    var curAvatarId: Int = 0
    private val flLayoutSportyList by lazy {
        arrayListOf(
            binding.flSporty1,
            binding.flSporty2,
            binding.flSporty3,
            binding.flSporty4,
            binding.flSporty5
        )
    }
    private val flLayoutHandsomeList by lazy {
        arrayListOf(
            binding.flHandsome1,
            binding.flHandsome2,
            binding.flHandsome3,
            binding.flHandsome4,
            binding.flHandsome5
        )
    }
    private val flLayoutCoolBoyList by lazy {
        arrayListOf(
            binding.flCoolBoy1,
            binding.flCoolBoy2,
            binding.flCoolBoy3,
            binding.flCoolBoy4,
            binding.flCoolBoy5
        )
    }
    private val flLayoutYoungBoyList by lazy {
        arrayListOf(
            binding.flYoungBoy1,
            binding.flYoungBoy2,
            binding.flYoungBoy3,
            binding.flYoungBoy4,
            binding.flYoungBoy5
        )
    }

    private val imgSportyList by lazy {
        arrayListOf(
            binding.imgSporty1,
            binding.imgSporty2,
            binding.imgSporty3,
            binding.imgSporty4,
            binding.imgSporty5
        )
    }
    private val imgHandsomeList by lazy {
        arrayListOf(
            binding.imgHandsome1,
            binding.imgHandsome2,
            binding.imgHandsome3,
            binding.imgHandsome4,
            binding.imgHandsome5
        )
    }
    private val imgCoolBoyList by lazy {
        arrayListOf(
            binding.imgCoolBoy1,
            binding.imgCoolBoy2,
            binding.imgCoolBoy3,
            binding.imgCoolBoy4,
            binding.imgCoolBoy5
        )
    }
    private val imgYoungBoyList by lazy {
        arrayListOf(
            binding.youngBoy1,
            binding.youngBoy2,
            binding.youngBoy3,
            binding.youngBoy4,
            binding.youngBoy5
        )
    }

    companion object {
        fun newInstance() = SelBoyAvatarFragment()
    }

    private lateinit var viewModel: SelBoyAvatarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SelBoyAvatarViewModel::class.java]
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
                (activity as SelBoyAvatarActivity).closeActivity()
            }
            flLayoutCouple.setOnClickListener {  //页面回退
                //保存数据
                ShareDataManager.updateCallback(curAvatarId)
                (activity as SelBoyAvatarActivity).closeActivity()
            }

            curAvatarId = viewModel.sportyAvatarList[0]
            curSelLayout = flLayoutSportyList[0]
            curSelShapeModel = curSelLayout?.getShapeModel()
            curSelShapeModel?.strokeColorCenter = Color.parseColor("#FFFFFF")
            curSelShapeModel?.strokeColorStart = Color.parseColor("#FFFFFF")
            curSelShapeModel?.strokeColorEnd = Color.parseColor("#FFFFFF")
            curSelLayout?.setShapeModel(curSelShapeModel!!)

            for ((index, value) in flLayoutSportyList.withIndex()) {
                value.setOnClickListener {
                    clickSelItemAvatar(value)
                    curAvatarId = viewModel.sportyAvatarList[index]
                }
            }
            for ((index, value) in flLayoutHandsomeList.withIndex()) {
                value.setOnClickListener {
                    clickSelItemAvatar(value)
                    curAvatarId = viewModel.handsomeAvatarList[index]
                }
            }
            for ((index, value) in flLayoutCoolBoyList.withIndex()) {
                value.setOnClickListener {
                    clickSelItemAvatar(value)
                    curAvatarId = viewModel.coolBoyAvatarList[index]
                }
            }
            for ((index, value) in flLayoutYoungBoyList.withIndex()) {
                value.setOnClickListener {
                    clickSelItemAvatar(value)
                    curAvatarId = viewModel.youngBoyAvatarList[index]
                }
            }

        }
    }

    private fun clickSelItemAvatar(flLayout: SShapeFrameLayout) {
        curSelShapeModel?.strokeColorCenter = Color.parseColor("#00000000")
        curSelShapeModel?.strokeColorEnd = Color.parseColor("#00000000")
        curSelShapeModel?.strokeColorStart = Color.parseColor("#00000000")
        curSelLayout?.setShapeModel(curSelShapeModel!!)
        curSelLayout = null
        curSelShapeModel = null
        val sp = flLayout.getShapeModel()
        sp.strokeColorCenter = Color.parseColor("#FFFFFF")
        sp.strokeColorEnd = Color.parseColor("#FFFFFF")
        sp.strokeColorStart = Color.parseColor("#FFFFFF")
        flLayout.setShapeModel(sp)
        curSelLayout = flLayout
        curSelShapeModel = sp
    }

    private fun initData() {
        for ((index, value) in viewModel.sportyAvatarList.withIndex()) {
            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(imgSportyList[index])
        }
        for ((index, value) in viewModel.handsomeAvatarList.withIndex()) {
            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(imgHandsomeList[index])
        }
        for ((index, value) in viewModel.coolBoyAvatarList.withIndex()) {
            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(imgCoolBoyList[index])
        }
        for ((index, value) in viewModel.youngBoyAvatarList.withIndex()) {
            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(imgYoungBoyList[index])
        }
    }

}