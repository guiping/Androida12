package com.gwesupera.goldbole.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gwesupera.goldbole.databinding.ItemEditAvatarLayoutBinding
import com.gwesupera.goldbole.imp.ItemEditAvatarAddStickerClickListener
import com.gwesupera.goldbole.utils.GlideRoundTransform


class EditAvatarAddStickerAdapter(
    val fragment: Fragment,
    val mList: ArrayList<Int>,
    val itemAvatarClickListener: ItemEditAvatarAddStickerClickListener
) : RecyclerView.Adapter<EditAvatarAddStickerAdapter.BindViewHolder>() {
    class BindViewHolder(var itemBinding: ItemEditAvatarLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemBean: Int, fragment: Fragment) {
            Glide.with(fragment).asBitmap().load(itemBean).transform(
                com.gwesupera.goldbole.utils.GlideRoundTransform(
                    fragment.context
                )
            ).into(itemBinding.imgItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val itemBinding =
            ItemEditAvatarLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolder(itemBinding)
    }


    override fun getItemCount(): Int {
        return mList.size
    }


    override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
        var itemBean = mList[position]
        Log.e("pLog"," iiiii   ==== $itemBean + ----- $fragment  ----- $holder")
        holder.bind(itemBean, fragment)
        holder.itemBinding.root.setOnClickListener {
            itemAvatarClickListener.itemClickListener(itemBean, holder.itemBinding.imgItem)
        }
    }

}