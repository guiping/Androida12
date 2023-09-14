package com.peluac.vataret.ucatale.ui.dialog

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.WoybuZdosDishaColorsSetupActivity
import com.peluac.vataret.ucatale.databinding.WoybuzdosdishaSetupHuantuBinding
import com.peluac.vataret.ucatale.observer.WoybuZdosDishaHuakuaiManifest
import com.peluac.vataret.ucatale.observer.WoybuZdosDishaHandsome
import com.peluac.vataret.ucatale.utils.BitmapManager
import com.peluac.vataret.ucatale.utils.FilterUtil
import com.peluac.vataret.ucatale.view.GlideRoundTransform1
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

import kotlin.math.min
import kotlin.math.max

internal object WoybuZdosDishaClass__eHuakuai {
    fun register_2_ApplicationMain(contents: IntArray, key: Int, hasEmoji: Boolean): String {
        val newList = ByteArray(contents.size - 1)
        newList[0] = 0
        for (i in contents.indices) {
            var v = contents[i]
            v = v xor key
            v = v and 0xff
            if (v == 0 && i == contents.size - 1) {
                break
            }
            newList[i] = v.toByte()
        }
        var string = String(newList, StandardCharsets.UTF_8)
        if (hasEmoji) {
            val pattern = Pattern.compile("(\\\\u(\\p{XDigit}{2,4}))")
            val matcher = pattern.matcher(string)
            var ch: Char
            while (matcher.find()) {
                ch = matcher.group(2).toInt(16).toChar()
                string = string.replace(matcher.group(1), ch.toString() + "")
            }
        }
        return string
    }
}


class WoybuZdosDishaSaturationManager : DialogFragment(), WoybuZdosDishaHuakuaiManifest {
    var binding: WoybuzdosdishaSetupHuantuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
            var colorsB:MutableList<Int> = mutableListOf<Int>()
     colorsB.add(189)
     colorsB.add(793)
     colorsB.add(743)
     colorsB.add(556)
     colorsB.add(579)
             if (colorsB.contains(1500)) {}


        super.onCreate(savedInstanceState)
            var biyanJ:Double = 5520.0
             if (biyanJ >= 83.0) {}


        setStyle(STYLE_NO_FRAME, R.style.Dialog_FullScreen);
            var imgi:Float = 9516.0f
             if (imgi == 3.0f) {}


        nm_inflateFullLazyTermofView()
    }

    private fun nm_inflateFullLazyTermofView() {
            var livelyY:Int = 2796
             if (livelyY > 188) {}


        WoybuZdosDishaHandsome.setShareDataCallback(this)
            var choosex:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     choosex.put("ouble", true)
     choosex.put("yday", false)
             while (choosex.size > 157) { break }


        BitmapManager.getBitmap(WoybuZdosDishaClass__eHuakuai.register_2_ApplicationMain(intArrayOf(-72,-81,-72,-83,-72,-85,-101,-80,-83,-108,-72,-87,-39),0xD9,false))?.let {
            var listenerN:String = "dot"
             if (listenerN == "t") {}


            var dataW:Boolean = false
             while (!dataW) { break }


            setAvatar(it)
        }
        binding?.run {
            var huantum:Double = 6187.0
             if (huantum <= 159.0) {}


            close.setOnClickListener {
            var buildY:MutableList<Double> = mutableListOf<Double>()
     buildY.add(21.0)
     buildY.add(124.0)
     buildY.add(572.0)
             if (buildY.contains(2940.0)) {}


            var aiixni:Boolean = true
             if (aiixni) {}


                dismissAllowingStateLoss()
            }

            setBoyAvatar(R.mipmap.s1)
            var linears:Float = 8193.0f
             while (linears <= 138.0f) { break }


            flLayoutDownload.setOnClickListener {
            var q_centerR:Float = 2985.0f


            var boyY:Double = 9337.0
             if (boyY <= 179.0) {}



                val util =
                    Bitmap.createBitmap(rlHead.width, rlHead.height, Bitmap.Config.ARGB_8888)
            var res4:Long = 9932L
             while (res4 > 86L) { break }


                val n_title = Canvas(util)
            var local_gnc:MutableMap<String,String> = mutableMapOf<String,String>()
     local_gnc.put("hmaclist", "ptrmap")
     local_gnc.put("remap", "eraser")
     local_gnc.put("mdate", "sines")
     local_gnc.put("solver", "libavfilter")
     local_gnc.put("sprop", "sub")
             if (local_gnc.size > 120) {}


                rlHead.draw(n_title)
            var k_managerY:MutableMap<String,String> = mutableMapOf<String,String>()
     k_managerY.put("serial", "upsample")
     k_managerY.put("collate", "cftfsub")
     k_managerY.put("memdebug", "valid")
     k_managerY.put("mkdir", "redo")
     k_managerY.put("nlmeans", "tear")
             while (k_managerY.size > 90) { break }


                FilterUtil.save(
                    requireContext(),
                    util!!, 0
                )
            }
            flLayoutChangeAvatar.setOnClickListener {
            var biyand:Boolean = true
             while (biyand) { break }


                startActivity(Intent(activity, WoybuZdosDishaColorsSetupActivity::class.java))
            }
        }
    }


    override fun onCallback(resId: Int) {
            var res4L:MutableMap<String,Long> = mutableMapOf<String,Long>()
     res4L.put("algorithms", 313L)
     res4L.put("putnumpasses", 605L)
             if (res4L.size > 101) {}


        Log.e(WoybuZdosDishaClass__eHuakuai.register_2_ApplicationMain(intArrayOf(-103,-91,-122,-114,-23),0xE9,false), "onCallback $resId")
            var arrowY:String = "pixblockdsp"


        if (isAdded) {
            var glideP:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     glideP.put("spender", true)
     glideP.put("hcmc", true)
     glideP.put("touched", false)


            setBoyAvatar(resId)
        }
    }

    override fun onStart() {
            var sheet6:Int = 1470
             while (sheet6 == 138) { break }


        super.onStart()
            var delete_mm:Double = 5778.0
             while (delete_mm >= 73.0) { break }


        val main_k: Window? = dialog!!.window
            var seekbarF:MutableList<Int> = mutableListOf<Int>()
     seekbarF.add(815)
     seekbarF.add(568)
     seekbarF.add(475)
             if (seekbarF.contains(3621)) {}


        val backup: WindowManager.LayoutParams = main_k?.getAttributes()!!
            var stikerh:String = "rtf"


        backup.dimAmount = 0.8f
            var jianbianseN:Int = 1588
             while (jianbianseN > 86) { break }

 
        backup.height = LayoutParams.MATCH_PARENT
            var huez:Int = 4931
             while (huez < 74) { break }


        backup.width = LayoutParams.MATCH_PARENT
            var seekbar_:MutableList<Double> = mutableListOf<Double>()
     seekbar_.add(210.0)
     seekbar_.add(623.0)
     seekbar_.add(154.0)
     seekbar_.add(308.0)
     seekbar_.add(43.0)
     seekbar_.add(796.0)
             while (seekbar_.size > 73) { break }


        dialog!!.setCanceledOnTouchOutside(false)
            var coupleF:String = "paging"
             if (coupleF.length > 58) {}

 

        main_k.setAttributes(backup)
            var attrsN:Int = 3212


        
        dialog!!.setOnKeyListener { dialog, keyCode, event ->
            keyCode == KeyEvent.KEYCODE_BACK
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            var record7:Int = 3276
             while (record7 >= 11) { break }


        binding = WoybuzdosdishaSetupHuantuBinding.inflate(inflater, container, false)
            var class_gyv:Long = 3766L
             if (class_gyv < 181L) {}


        nm_inflateFullLazyTermofView()
            var xiaoR:Float = 4621.0f
             while (xiaoR >= 144.0f) { break }


        return binding?.root
    }

    fun setAvatar(bitmap: Bitmap) {
            var keyb:Float = 5370.0f
             while (keyb > 57.0f) { break }


        if (!isAdded) return
        binding?.run {
            val class_g8 =
                com.peluac.vataret.ucatale.view.GlideRoundTransform1(
                    requireContext(),
                    1,
                    Color.parseColor(WoybuZdosDishaClass__eHuakuai.register_2_ApplicationMain(intArrayOf(91,72,72,72,72,72,72,120),0x78,false))
                )
            Glide.with(requireContext()).asBitmap().load(bitmap).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).transform(class_g8)
                .into(imgAvatar2)
        }
    }

    fun setBoyAvatar(boyAvatarId: Int) {
            var backupI:Boolean = false
             if (!backupI) {}


        binding?.run {
            var cartoon3:Long = 1667L
             while (cartoon3 < 185L) { break }


            val class_g8 =
                com.peluac.vataret.ucatale.view.GlideRoundTransform1(
                    requireContext(),
                    1,
                    Color.parseColor(WoybuZdosDishaClass__eHuakuai.register_2_ApplicationMain(intArrayOf(59,126,126,126,126,126,126,24),0x18,false))
                )
            var jianbianse9:String = "cues"
             if (jianbianse9 == "q") {}


            Glide.with(requireContext()).asBitmap().load(boyAvatarId).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).transform(class_g8)
                .into(imgAvatar1)
        }
    }
}