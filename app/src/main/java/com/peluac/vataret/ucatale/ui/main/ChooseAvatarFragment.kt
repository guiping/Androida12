package com.peluac.vataret.ucatale.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.peluac.vataret.ucatale.AvatarType
import com.peluac.vataret.ucatale.MainActivity
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.databinding.FragmentChooseAvatarBinding
import com.peluac.vataret.ucatale.imp.ItemAvatarClickListener
import com.peluac.vataret.ucatale.ui.dialog.AllCategoriesDialog
import com.peluac.vataret.ucatale.view.SShapeFrameLayout
import com.peluac.vataret.ucatale.view.SShapeModel

class ChooseAvatarFragment : Fragment() {
    val binding: FragmentChooseAvatarBinding by lazy {
        FragmentChooseAvatarBinding.inflate(layoutInflater)
    }

    companion object {
        fun newInstance() = ChooseAvatarFragment()
    }

    private lateinit var viewModel: ChooseAvatarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ChooseAvatarViewModel::class.java]
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
            imgAvatar.setOnClickListener {
                (activity as MainActivity).switchEditAvatarFragment(
                    type!!,
                    resId!!
                )
            }
            imgEditEnter.setOnClickListener {
                (activity as MainActivity).switchEditAvatarFragment(
                    type!!,
                    resId!!
                )
            }
            flTouxiang.setOnClickListener {view-> selectAvatar(type!!, 0 ) }
            flTouxiang1.setOnClickListener { selectAvatar(type!!, 1 ) }
            flTouxiang2.setOnClickListener { selectAvatar(type!!, 2 ) }
            flTouxiang3.setOnClickListener { selectAvatar(type!!, 3 ) }
            flTouxiang4.setOnClickListener { selectAvatar(type!!, 4 ) }
            val allCategoriesDialog = AllCategoriesDialog()
            allCategoriesDialog.setItemClickCallback(object : ItemAvatarClickListener {
                override fun itemClickListener(type: Int) {
                    selectAvatar(type,0 )
                }
            })
            flAllCategories.setOnClickListener {
                allCategoriesDialog.show(parentFragmentManager, "AllCategoriesDialog")
            }
        }

    }

    var type: Int? = 0
    private fun initData() {
        type = arguments?.getInt("type")
        if (type == null) {
            type = AvatarType.CARTOON
        }
        Log.e("pLog", "type = $type")
        selectAvatar(type!!,0 )
    }
    var resId = 0
    fun selectAvatar(type: Int, index: Int) {
        updateItemSel(type,index)
        this.type = type
        when (type) {
            AvatarType.CARTOON -> {
                resId = viewModel.avatarCartoonList[index]
            }
            AvatarType.CLASSY -> {
                resId = viewModel.avatarClassList[index]
            }
            AvatarType.YOUTH -> {
                resId = viewModel.avatarYouthList[index]
            }
            AvatarType.COOL -> {
                resId = viewModel.avatarCoolList[index]
            }
            AvatarType.LIVELY -> {
                resId = viewModel.avatarLivelyList[index]
            }
            else -> {
                resId = viewModel.avatarClassList[index]
            }
        }
        Glide.with(this).asBitmap().load(resId).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgAvatar)
    }
    var curShamodel: SShapeModel? = null
    var curFlLayout: SShapeFrameLayout? = null
    fun updateItemSel(type: Int,index:Int) {

        val touxiangSp = binding.flTouxiang.getShapeModel()
        touxiangSp.solidColorCenter = Color.parseColor("#000000")
        touxiangSp.solidColorEnd = Color.parseColor("#000000")
        touxiangSp.solidColorStart = Color.parseColor("#000000")
        binding.touxiang.setImageResource(R.mipmap.heise_touxiang)
        binding.biyan.visibility = View.VISIBLE
        val touxiang1Sp = binding.flTouxiang1.getShapeModel()
        touxiang1Sp.solidColorCenter = Color.parseColor("#000000")
        touxiang1Sp.solidColorEnd = Color.parseColor("#000000")
        touxiang1Sp.solidColorStart = Color.parseColor("#000000")
        binding.touxiang1.setImageResource(R.mipmap.heise_touxiang)
        binding.biyan1.visibility = View.VISIBLE
        val touxiang2Sp = binding.flTouxiang2.getShapeModel()
        touxiang2Sp.solidColorCenter = Color.parseColor("#000000")
        touxiang2Sp.solidColorEnd = Color.parseColor("#000000")
        touxiang2Sp.solidColorStart = Color.parseColor("#000000")
        binding.touxiang2.setImageResource(R.mipmap.heise_touxiang)
        binding.biyan2.visibility = View.VISIBLE
        val touxiang3Sp = binding.flTouxiang3.getShapeModel()
        touxiang3Sp.solidColorCenter = Color.parseColor("#000000")
        touxiang3Sp.solidColorEnd = Color.parseColor("#000000")
        touxiang3Sp.solidColorStart = Color.parseColor("#000000")
        binding.touxiang3.setImageResource(R.mipmap.heise_touxiang)
        binding.biyan3.visibility = View.VISIBLE
        val touxiang4Sp = binding.flTouxiang4.getShapeModel()
        touxiang4Sp.solidColorCenter = Color.parseColor("#000000")
        touxiang4Sp.solidColorEnd = Color.parseColor("#000000")
        touxiang4Sp.solidColorStart = Color.parseColor("#000000")
        binding.touxiang4.setImageResource(R.mipmap.heise_touxiang)
        binding.biyan4.visibility = View.VISIBLE
        when (index) {
            0 -> {
                touxiangSp.solidColorCenter = Color.parseColor("#FE203A")
                touxiangSp.solidColorEnd = Color.parseColor("#FE203A")
                touxiangSp.solidColorStart = Color.parseColor("#FE203A")
                binding.touxiang.setImageResource(R.mipmap.baise_touxiang)
                binding.biyan.visibility = View.GONE
            }
            1 -> {
                touxiang1Sp.solidColorCenter = Color.parseColor("#FE203A")
                touxiang1Sp.solidColorEnd = Color.parseColor("#FE203A")
                touxiang1Sp.solidColorStart = Color.parseColor("#FE203A")
                binding.touxiang1.setImageResource(R.mipmap.baise_touxiang)
                binding.biyan1.visibility = View.GONE

            }
            2 -> {
                touxiang2Sp.solidColorCenter = Color.parseColor("#FE203A")
                touxiang2Sp.solidColorEnd = Color.parseColor("#FE203A")
                touxiang2Sp.solidColorStart = Color.parseColor("#FE203A")
                binding.touxiang2.setImageResource(R.mipmap.baise_touxiang)
                binding.biyan2.visibility = View.GONE
            }
            3 -> {
                touxiang3Sp.solidColorCenter = Color.parseColor("#FE203A")
                touxiang3Sp.solidColorEnd = Color.parseColor("#FE203A")
                touxiang3Sp.solidColorStart = Color.parseColor("#FE203A")
                binding.touxiang3.setImageResource(R.mipmap.baise_touxiang)
                binding.biyan3.visibility = View.GONE
            }
            4 -> {
                touxiang4Sp.solidColorCenter = Color.parseColor("#FE203A")
                touxiang4Sp.solidColorEnd = Color.parseColor("#FE203A")
                touxiang4Sp.solidColorStart = Color.parseColor("#FE203A")
                binding.touxiang4.setImageResource(R.mipmap.baise_touxiang)
                binding.biyan4.visibility = View.GONE
            }
            else -> {
                touxiangSp.solidColorCenter = Color.parseColor("#FE203A")
                touxiangSp.solidColorEnd = Color.parseColor("#FE203A")
                touxiangSp.solidColorStart = Color.parseColor("#FE203A")
                binding.touxiang.setImageResource(R.mipmap.baise_touxiang)
                binding.biyan.visibility = View.GONE
            }
        }
        binding.flTouxiang.setShapeModel(touxiangSp)
        binding.flTouxiang1.setShapeModel(touxiang1Sp)
        binding.flTouxiang2.setShapeModel(touxiang2Sp)
        binding.flTouxiang3.setShapeModel(touxiang3Sp)
        binding.flTouxiang4.setShapeModel(touxiang4Sp)
    }
}