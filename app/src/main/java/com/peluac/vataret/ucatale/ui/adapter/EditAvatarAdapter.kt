package com.peluac.vataret.ucatale.ui.adapter

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peluac.vataret.ucatale.databinding.ItemEditAvatarLayoutBinding
import com.peluac.vataret.ucatale.imp.ItemEditAvatarClickListener
import com.peluac.vataret.ucatale.utils.GlideRoundTransform


class EditAvatarAdapter(
    val fragment: Fragment,
    val mList: ArrayList<FloatArray>,
    val itemAvatarClickListener: ItemEditAvatarClickListener
) :
    RecyclerView.Adapter<EditAvatarAdapter.BindViewHolder>() {

    var avatarId: Int? = null

    class BindViewHolder(var itemBinding: ItemEditAvatarLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(itemBean: Int, colormatrix: FloatArray, fragment: Fragment) {
            Glide.with(fragment).asBitmap().load(itemBean).transform(
                com.peluac.vataret.ucatale.utils.GlideRoundTransform(
                    fragment.context
                )
            )
                .into(itemBinding.imgItem)
            var colorMatrix = ColorMatrix()
            colorMatrix.set(colormatrix)
            itemBinding.imgItem.colorFilter = ColorMatrixColorFilter(colorMatrix)
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

    fun setAvatarId(id: Int) {
        this.avatarId = id
    }

    override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
        var itemBean = mList[position]
        holder.bind(avatarId!!, itemBean, fragment)
        holder.itemBinding.root.setOnClickListener {
            itemAvatarClickListener.itemClickListener(itemBean)
        }
    }

}