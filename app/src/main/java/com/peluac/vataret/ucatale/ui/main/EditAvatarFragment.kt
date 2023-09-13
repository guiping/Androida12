package com.peluac.vataret.ucatale.ui.main

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.peluac.vataret.ucatale.MainActivity
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.databinding.FragmentEditAvatarBinding
import com.peluac.vataret.ucatale.imp.ItemEditAvatarAddStickerClickListener
import com.peluac.vataret.ucatale.imp.ItemEditAvatarClickListener
import com.peluac.vataret.ucatale.ui.adapter.EditAvatarAdapter
import com.peluac.vataret.ucatale.ui.adapter.EditAvatarAddStickerAdapter
import com.peluac.vataret.ucatale.ui.dialog.CoupleAvatarDialog
import com.peluac.vataret.ucatale.utils.BitmapManager

import com.peluac.vataret.ucatale.utils.FilterUtil
import java.io.ByteArrayOutputStream

class EditAvatarFragment : Fragment(), ItemEditAvatarClickListener,
    ItemEditAvatarAddStickerClickListener {
    val binding: FragmentEditAvatarBinding by lazy {
        FragmentEditAvatarBinding.inflate(layoutInflater)
    }

    companion object {
        fun newInstance() = EditAvatarFragment()
    }

    val avatarIdList = ArrayList<FloatArray>()
    var curAvatarId: Int? = null
    private val editAvatarAdapter: EditAvatarAdapter by lazy {
        EditAvatarAdapter(this, avatarIdList, this)
    }
    val stickerIdList = ArrayList<Int>()
    val stickerAdapter by lazy {
        EditAvatarAddStickerAdapter(this, stickerIdList, this)
    }

    private lateinit var viewModel: EditAvatarViewModel
    private val mHue = 1.0f
    private var mStauration = 1.0f
    private var mLum = 1.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[EditAvatarViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initView()
        initData()
        return binding.root
    }

    var imgAvatarBitmap: Bitmap? = null
    var coupleAvatarDialog: CoupleAvatarDialog? = null
    private fun initView() {
        binding.run {
            imgBack.setOnClickListener {
                (activity as MainActivity).switchChooseAvatar(type!!)
            }
            flLayoutSave.setOnClickListener {
                val mergeBitMap =
                    FilterUtil.negativeBitmap(
                        imgToBitMap(imgAvatar),
                        stickerView.maskBitmap,
                        null,
                        null
                    )
                FilterUtil.save(requireContext(), mergeBitMap!!, 0);
            }
            coupleAvatarDialog = CoupleAvatarDialog()
            flLayoutCouple.setOnClickListener {
                val mergeBitMap =
                    FilterUtil.negativeBitmap(
                        imgToBitMap(imgAvatar),
                        stickerView.maskBitmap,
                        null,
                        null
                    )
                BitmapManager.setBitmap("avatarBitMap", mergeBitMap!!)
                coupleAvatarDialog?.let {
                    if (!it.isAdded || !it.isVisible)
                        it.show(parentFragmentManager, "CoupleAvatarDialog")
                }

            }

            llSelAvatar.visibility = View.VISIBLE
            //加载View
            rvListAvatar.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            rvListAvatar.adapter = editAvatarAdapter

            rvListSticker
            rvListSticker.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            rvListSticker.adapter = stickerAdapter

            tvFailter1.setOnClickListener {
                avatarIdList.clear()
                avatarIdList.addAll(viewModel.failter1List)
                editAvatarAdapter.notifyDataSetChanged()
                rvListAvatar.scrollToPosition(0)
                tvFailter2.alpha = 0.4f
                tvFailter1.alpha = 1f
            }
            tvFailter2.setOnClickListener {
                avatarIdList.clear()
                avatarIdList.addAll(viewModel.failter2List)
                editAvatarAdapter.notifyDataSetChanged()
                rvListAvatar.scrollToPosition(0)
                tvFailter1.alpha = 0.4f
                tvFailter2.alpha = 1f
            }

            tvSticker1.setOnClickListener {
                stickerIdList.clear()
                stickerIdList.addAll(viewModel.stiker1List)
                stickerAdapter.notifyDataSetChanged()
                rvListSticker.scrollToPosition(0)
                tvSticker2.alpha = 0.4f
                tvSticker1.alpha = 1f
            }
            tvSticker2.setOnClickListener {
                stickerIdList.clear()
                stickerIdList.addAll(viewModel.stiker2List)
                stickerAdapter.notifyDataSetChanged()
                rvListSticker.scrollToPosition(0)
                tvSticker1.alpha = 0.4f
                tvSticker2.alpha = 1f
            }
            imgSticker.setOnClickListener {
                flAvatarBaohedu.visibility = View.GONE
                llSelAvatar.visibility = View.GONE
                llSelSticker.visibility = View.VISIBLE
                imgSticker.setImageResource(R.mipmap.sel_tiezhi)
                imgSwitchAvatar.setImageResource(R.mipmap.huantu_hei)
                imgAvatarSet.setImageResource(R.mipmap.baohedu_hei)
            }
            imgSwitchAvatar.setOnClickListener {
                flAvatarBaohedu.visibility = View.GONE
                llSelAvatar.visibility = View.VISIBLE
                llSelSticker.visibility = View.GONE
                imgSticker.setImageResource(R.mipmap.nosel_tiezhi)
                imgSwitchAvatar.setImageResource(R.mipmap.sel_tiezhi)
                imgAvatarSet.setImageResource(R.mipmap.baohedu_hei)
            }
            imgAvatarSet.setOnClickListener {
                flAvatarBaohedu.visibility = View.VISIBLE
                llSelAvatar.visibility = View.GONE
                llSelSticker.visibility = View.GONE
                imgSticker.setImageResource(R.mipmap.nosel_tiezhi)
                imgSwitchAvatar.setImageResource(R.mipmap.huantu_hei)
                imgAvatarSet.setImageResource(R.mipmap.baohedu_bai)
            }
            seekBar.progress = seekBar.progress
            seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (imgAvatarBitmap == null) {
                        imgAvatarBitmap = imgToBitMap(imgAvatar)
                    }
                    mStauration = progress * 1.0F / 50;
                    imgAvatar.setImageBitmap(
                        FilterUtil.beautyImage(
                            imgAvatarBitmap!!, 1f, mStauration, mLum
                        )
                    )

                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })
            seekBarVignette.progress = seekBarVignette.progress
            seekBarVignette.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (imgAvatarBitmap == null) {
                        imgAvatarBitmap = imgToBitMap(imgAvatar)
                    }

                    mLum = progress * 1.0F / 50;
                    imgAvatar.setImageBitmap(
                        FilterUtil.beautyImage(
                            imgAvatarBitmap!!,
                            1f,
                            mStauration,
                            mLum
                        )
                    )
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })

        }

    }

    var type: Int? = 0
    var avatarId: Int? = 0
    private fun initData() {
        val bundle = arguments
        if (bundle == null) {
            (activity as MainActivity).switchHomeFragment()
        }
        bundle?.run {
            type = getInt("type")
            avatarId = getInt("avatarId")

            loadAvatar(avatarId!!)
        }
        avatarIdList.clear()
        avatarIdList.addAll(viewModel.failter1List)
        editAvatarAdapter.setAvatarId(avatarId!!)
        editAvatarAdapter.notifyDataSetChanged()
        stickerIdList.clear()
        stickerIdList.addAll(viewModel.stiker1List)
        stickerAdapter.notifyDataSetChanged()
    }

    private fun loadAvatar(avatarId: Int) {
        curAvatarId = avatarId
        Glide.with(this).asBitmap().load(avatarId).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgAvatar)
        binding.imgAvatar.setImageResource(avatarId)
    }

    override fun itemClickListener(type: FloatArray) {
        var colorMatrix = ColorMatrix()
        colorMatrix.set(type)
        binding.imgAvatar.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    override fun itemClickListener(resId: Int, imageView: ImageView) {
        binding.stickerView.addDecal(imgToBitMap(imageView), true, "", 0, null)
    }

    fun imgToBitMap(v: View?): Bitmap? {
        if (v == null) {
            return null
        }
        if (v.measuredWidth == 0) {
            return null
        }
        if (v.measuredHeight == 0) {
            return null
        }
        val screenshot: Bitmap =
            Bitmap.createBitmap(v.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(screenshot)
        canvas.translate(-v.scrollX.toFloat(), -v.scrollY.toFloat())
        v.draw(canvas)
        return screenshot
    }
}