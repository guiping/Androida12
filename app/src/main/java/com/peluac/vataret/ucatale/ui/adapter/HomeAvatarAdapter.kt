package com.peluac.vataret.ucatale.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.peluac.vataret.ucatale.databinding.ItemHomeLayoutBinding
import com.peluac.vataret.ucatale.imp.ItemAvatarClickListener
import com.peluac.vataret.ucatale.model.HomeItemModel
import com.peluac.vataret.ucatale.view.GlideRoundTransform1


class HomeAvatarAdapter(
    val fragment: Fragment,
    val mList: ArrayList<HomeItemModel>,
    val itemAvatarClickListener: ItemAvatarClickListener
) :
    RecyclerView.Adapter<HomeAvatarAdapter.BindViewHolder>() {
    class BindViewHolder(var itemBinding: ItemHomeLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemBean: HomeItemModel, fragment: Fragment) {
            itemBinding.tvItemName.text = itemBean.itemName
            val requestOptions =
                com.peluac.vataret.ucatale.view.GlideRoundTransform1(
                    fragment.requireContext(),
                    1,
                    Color.parseColor("#ffffff")
                )
            Glide.with(fragment).asBitmap().load(itemBean.avatarId).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).transform(requestOptions)
                .into(itemBinding.imgItemHead)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val itemBinding =
            ItemHomeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolder(itemBinding)
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
        var itemBean = mList[position]
        holder.bind(itemBean, fragment)
        holder.itemBinding.root.setOnClickListener {
            itemAvatarClickListener.itemClickListener(itemBean.type)
        }
    }

}