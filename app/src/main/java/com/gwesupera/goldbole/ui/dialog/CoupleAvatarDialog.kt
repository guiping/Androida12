package com.gwesupera.goldbole.ui.dialog

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.ViewGroup.LayoutParams
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.gwesupera.goldbole.R
import com.gwesupera.goldbole.SelBoyAvatarActivity
import com.gwesupera.goldbole.databinding.DialogCoupleAvatarLayoutBinding
import com.gwesupera.goldbole.observer.ObserverCallback
import com.gwesupera.goldbole.observer.ShareDataManager
import com.gwesupera.goldbole.utils.BitmapManager
import com.gwesupera.goldbole.utils.FilterUtil
import com.gwesupera.goldbole.view.GlideRoundTransform1


class CoupleAvatarDialog : DialogFragment(), ObserverCallback {
    var binding: DialogCoupleAvatarLayoutBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogCoupleAvatarLayoutBinding.inflate(inflater, container, false)
        initView()
        return binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.Dialog_FullScreen);
        initView()
    }


    fun setAvatar(bitmap: Bitmap) {
        if (!isAdded) return
        binding?.run {
            val requestOptions =
                com.gwesupera.goldbole.view.GlideRoundTransform1(
                    requireContext(),
                    1,
                    Color.parseColor("#000000")
                )
            Glide.with(requireContext()).asBitmap().load(bitmap).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).transform(requestOptions)
                .into(imgAvatar2)
        }
    }

    fun setBoyAvatar(boyAvatarId: Int) {
        binding?.run {
            val requestOptions =
                com.gwesupera.goldbole.view.GlideRoundTransform1(
                    requireContext(),
                    1,
                    Color.parseColor("#ffffff")
                )
            Glide.with(requireContext()).asBitmap().load(boyAvatarId).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).transform(requestOptions)
                .into(imgAvatar1)
        }
    }

    override fun onStart() {
        super.onStart()
        val window: Window? = dialog!!.window
        val windowParams: WindowManager.LayoutParams = window?.getAttributes()!!
        windowParams.dimAmount = 0.8f //将Window周边设置透明为0.7
        windowParams.height = LayoutParams.MATCH_PARENT
        windowParams.width = LayoutParams.MATCH_PARENT
        dialog!!.setCanceledOnTouchOutside(false) //点击周边不隐藏对话框

        window.setAttributes(windowParams)
        //点击返回键不隐藏对话框
        dialog!!.setOnKeyListener { dialog, keyCode, event ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }

    private fun initView() {
        ShareDataManager.setShareDataCallback(this)
//        arguments?.run {
//            val byteArray = getByteArray("bitmap")
//            if (byteArray != null) {
//                val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//                setAvatar(bitmap)
//            }
//        }
        BitmapManager.getBitmap("avatarBitMap")?.let {
            setAvatar(it)
        }
        binding?.run {
            close.setOnClickListener {
                dismissAllowingStateLoss()
            }

            setBoyAvatar(R.mipmap.s1)
            flLayoutDownload.setOnClickListener {

                val bitmap =
                    Bitmap.createBitmap(rlHead.width, rlHead.height, Bitmap.Config.ARGB_8888)
                val canvas = Canvas(bitmap)
                rlHead.draw(canvas)
                FilterUtil.save(
                    requireContext(),
                    bitmap!!, 0
                )
            }
            flLayoutChangeAvatar.setOnClickListener {
                startActivity(Intent(activity, SelBoyAvatarActivity::class.java))
            }
        }
    }

    override fun onCallback(resId: Int) {
        Log.e("pLog", "onCallback $resId")
        if (isAdded) {
            setBoyAvatar(resId)
        }
    }
}