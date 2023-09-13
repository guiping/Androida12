package com.peluac.vataret.ucatale.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.peluac.vataret.ucatale.AvatarType
import com.peluac.vataret.ucatale.MainActivity
import com.peluac.vataret.ucatale.databinding.FragmentHomeBinding
import com.peluac.vataret.ucatale.imp.ItemAvatarClickListener
import com.peluac.vataret.ucatale.model.HomeItemModel
import com.peluac.vataret.ucatale.ui.adapter.HomeAvatarAdapter

class HomeFragment : Fragment(), ItemAvatarClickListener {
    val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private val avatarList = ArrayList<HomeItemModel>()
    val homeAvatarAdapter by lazy {
        HomeAvatarAdapter(this, avatarList, this)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
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
        binding.rvAvatar.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvAvatar.adapter = homeAvatarAdapter

        binding.run {
            imgSetting.setOnClickListener {
                (activity as MainActivity).switchSetUpFragment()
            }
            imgNext.setOnClickListener { (activity as MainActivity).switchChooseAvatar(AvatarType.CARTOON) }
            llCartoon.setOnClickListener {
                (activity as MainActivity).switchChooseAvatar(AvatarType.CARTOON)
            }
            llClassy.setOnClickListener {
                (activity as MainActivity).switchChooseAvatar(AvatarType.CLASSY)
            }
            llYouth.setOnClickListener {
                (activity as MainActivity).switchChooseAvatar(AvatarType.YOUTH)
            }
            llCool.setOnClickListener {
                (activity as MainActivity).switchChooseAvatar(AvatarType.COOL)
            }
            llLively.setOnClickListener {
                (activity as MainActivity).switchChooseAvatar(AvatarType.LIVELY)
            }

        }
    }

    private fun initData() {
        viewModel.getAvatarData(requireContext())
        viewModel.homeItemList.observe(viewLifecycleOwner) { data ->
            Log.e("pLog", "数据组装成功=---  ${data.size}")
            avatarList.clear()
            avatarList.addAll(data)
            homeAvatarAdapter.notifyDataSetChanged()
        }
    }

    override fun itemClickListener(type: Int) {
        (activity as MainActivity).switchChooseAvatar(type)
    }
}