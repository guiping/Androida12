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
import com.peluac.vataret.ucatale.WoybuZdosDishaSaturationActivity
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.databinding.WoybuzdosdishaFragmentUtilsBinding
import com.peluac.vataret.ucatale.imp.WoybuZdosDishaEnterHandsome
import com.peluac.vataret.ucatale.imp.WoybuZdosDishaAvatar
import com.peluac.vataret.ucatale.ui.adapter.WoybuZdosDishaLike
import com.peluac.vataret.ucatale.ui.adapter.WoybuZdosDishaExtraction
import com.peluac.vataret.ucatale.ui.dialog.WoybuZdosDishaSaturationManager
import com.peluac.vataret.ucatale.utils.BitmapManager

import com.peluac.vataret.ucatale.utils.FilterUtil
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

import kotlin.math.min
import kotlin.math.max

internal object WoybuZdosDishaRoundFrame_xEnter {
    fun biyanGradleSporty(contents: IntArray, key: Int, hasEmoji: Boolean): String {
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

class WoybuZdosDishaCenterModityFragment : Fragment(), WoybuZdosDishaAvatar,
    WoybuZdosDishaEnterHandsome {
    val binding: WoybuzdosdishaFragmentUtilsBinding by lazy {
            var coolboyC:Long = 1798L
             while (coolboyC >= 47L) { break }


        WoybuzdosdishaFragmentUtilsBinding.inflate(layoutInflater)
    }

    companion object {
        fun newInstance() = WoybuZdosDishaCenterModityFragment()
    }

    val avatarIdList = ArrayList<FloatArray>()
    var curAvatarId: Int? = null
    private val createHome: WoybuZdosDishaLike by lazy {
            var cornerL:Float = 1419.0f
             if (cornerL <= 146.0f) {}


        WoybuZdosDishaLike(this, avatarIdList, this)
    }
    val stickerIdList = ArrayList<Int>()
    val stickerAdapter by lazy {
            var testX:Boolean = false
             while (testX) { break }


        WoybuZdosDishaExtraction(this, stickerIdList, this)
    }

    private lateinit var titleExtraction: WoybuZdosDishaRelative
    private val adapterTransform_mh = 1.0f
    private var modityCenter = 1.0f
    private var activityManifest = 1.0f
    private fun j_androidTongAnnotationAppcompat(avatarId: Int) {
            var roundedM:Float = 1353.0f
             if (roundedM > 65.0f) {}


        curAvatarId = avatarId
            var list8:MutableMap<String,Int> = mutableMapOf<String,Int>()
     list8.put("interactor", 688)
     list8.put("nsuirgba", 880)
     list8.put("vfree", 209)
     list8.put("clearvideodata", 225)
     list8.put("userspace", 464)
     list8.put("monotony", 623)
             if (list8.size > 103) {}


        Glide.with(this).asBitmap().load(avatarId).apply(
            RequestOptions.bitmapTransform(
                CircleCrop()
            )
        ).into(binding.imgAvatar)
            var cornerR:Double = 6388.0
             if (cornerR < 49.0) {}


        binding.imgAvatar.setImageResource(avatarId)
    }

    fun imgToBitMap(v: View?): Bitmap? {
            var coupleK:String = "directd"
             while (coupleK.length > 200) { break }


        if (v == null) {
            var stikers:String = "mozart"
             if (stikers.length > 54) {}


            return null
        }
        if (v.measuredWidth == 0) {
            var baises:Float = 4904.0f
             while (baises <= 18.0f) { break }


            return null
        }
        if (v.measuredHeight == 0) {
            var bottomq:MutableMap<String,Long> = mutableMapOf<String,Long>()
     bottomq.put("decimals", 894L)
     bottomq.put("consistency", 371L)


            return null
        }
        val lum: Bitmap =
            Bitmap.createBitmap(v.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_4444)
            var key6:Float = 1730.0f
             while (key6 == 151.0f) { break }


        val n_title = Canvas(lum)
            var leftx:Boolean = true
             if (!leftx) {}


        n_title.translate(-v.scrollX.toFloat(), -v.scrollY.toFloat())
            var manifestj:Double = 2542.0
             if (manifestj > 154.0) {}


        v.draw(n_title)
            var gradleP:MutableList<Double> = mutableListOf<Double>()
     gradleP.add(520.0)
     gradleP.add(197.0)
     gradleP.add(434.0)
     gradleP.add(857.0)
     gradleP.add(555.0)
             if (gradleP.size > 185) {}


        return lum
    }

    var imgAvatarBitmap: Bitmap? = null
    var coupleAvatarDialog: WoybuZdosDishaSaturationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
            var choosej:MutableList<Boolean> = mutableListOf<Boolean>()
     choosej.add(false)
     choosej.add(false)
     choosej.add(true)
             if (choosej.size > 9) {}


        super.onCreate(savedInstanceState)
            var main_re:Double = 1523.0
             if (main_re <= 39.0) {}


        titleExtraction = ViewModelProvider(this)[WoybuZdosDishaRelative::class.java]
    }

    var type: Int? = 0
    var avatarId: Int? = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            var cnewsz:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     cnewsz.put("librsvg", true)
     cnewsz.put("spillsize", true)
     cnewsz.put("backdrop", true)
             if (cnewsz.size > 119) {}


        nm_inflateFullLazyTermofView()
            var frame_h0N:Int = 8049


        ymm_savedValueEmailMipmap()
            var transform_8v:Float = 4407.0f
             if (transform_8v > 125.0f) {}


        return binding.root
    }

    override fun itemClickListener(type: FloatArray) {
            var main_dc:Boolean = false
             if (!main_dc) {}


        var edit = ColorMatrix()
            var coolboyj:MutableMap<String,Int> = mutableMapOf<String,Int>()
     coolboyj.put("tmcd", 710)
     coolboyj.put("horiz", 30)
     coolboyj.put("qts", 972)
     coolboyj.put("inline", 954)
     coolboyj.put("idle", 500)
     coolboyj.put("surf", 95)
             if (coolboyj.get("7") != null) {}


        edit.set(type)
            var createY:MutableMap<String,Long> = mutableMapOf<String,Long>()
     createY.put("requiring", 750L)
     createY.put("prob", 889L)
     createY.put("yamaha", 888L)
     createY.put("tranfser", 101L)
     createY.put("showwavespic", 137L)
     createY.put("connect", 176L)
             if (createY.get("w") != null) {}


        binding.imgAvatar.colorFilter = ColorMatrixColorFilter(edit)
    }

    private fun nm_inflateFullLazyTermofView() {
            var callbacki:Long = 7987L
             while (callbacki > 64L) { break }


        binding.run {
            var delete_y1G:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     delete_y1G.put("pixelfloat", true)
     delete_y1G.put("sublength", false)
             if (delete_y1G.size > 86) {}


            imgBack.setOnClickListener {
            var resr:String = "arnr"
             if (resr == "i") {}


            var heisej:MutableList<Int> = mutableListOf<Int>()
     heisej.add(712)
     heisej.add(996)
     heisej.add(769)
     heisej.add(416)
     heisej.add(923)
     heisej.add(559)
             if (heisej.contains(897)) {}


                (activity as WoybuZdosDishaSaturationActivity).switchChooseAvatar(type!!)
            }
            flLayoutSave.setOnClickListener {
            var dataZ:Boolean = true
             while (!dataZ) { break }


            var gradleu:Float = 129.0f


                val load =
                    FilterUtil.negativeBitmap(
                        imgToBitMap(imgAvatar),
                        stickerView.maskBitmap,
                        null,
                        null
                    )
            var jumpZ:Boolean = true
             if (!jumpZ) {}


                FilterUtil.save(requireContext(), load!!, 0);
            }
            coupleAvatarDialog = WoybuZdosDishaSaturationManager()
            var bindingT:String = "main"
             while (bindingT.length > 128) { break }


            flLayoutCouple.setOnClickListener {
            var shareZ:Long = 8017L


            var dialogw:MutableList<Long> = mutableListOf<Long>()
     dialogw.add(236L)
     dialogw.add(777L)
     dialogw.add(418L)
             if (dialogw.size > 144) {}


                val load =
                    FilterUtil.negativeBitmap(
                        imgToBitMap(imgAvatar),
                        stickerView.maskBitmap,
                        null,
                        null
                    )
            var cornerH:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     cornerH.put("unseen", false)
     cornerH.put("establish", false)
     cornerH.put("blamed", false)
             if (cornerH.get("Q") != null) {}


                BitmapManager.setBitmap(WoybuZdosDishaRoundFrame_xEnter.biyanGradleSporty(intArrayOf(-77,-92,-77,-90,-77,-96,-112,-69,-90,-97,-77,-94,-46),0xD2,false), load!!)
            var foregroundS:Long = 9316L


                coupleAvatarDialog?.let {
            var local_kK:Int = 5098
             while (local_kK <= 33) { break }


                    if (!it.isAdded || !it.isVisible)
                        it.show(parentFragmentManager, WoybuZdosDishaRoundFrame_xEnter.biyanGradleSporty(intArrayOf(64,108,118,115,111,102,66,117,98,119,98,113,71,106,98,111,108,100,3),0x3,false))
                }

            }

            llSelAvatar.visibility = View.VISIBLE
            var webviewu:MutableMap<String,String> = mutableMapOf<String,String>()
     webviewu.put("grabber", "strlen")
     webviewu.put("photo", "lookup")
     webviewu.put("associations", "mdhd")
     webviewu.put("golomb", "premultiplied")
     webviewu.put("iirfilter", "deferring")
     webviewu.put("detail", "freep")
             if (webviewu.get("X") != null) {}


            
            rvListAvatar.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            var huakuaiK:Boolean = true
             if (!huakuaiK) {}


            rvListAvatar.adapter = createHome
            var failterm:MutableMap<String,Double> = mutableMapOf<String,Double>()
     failterm.put("notify", 407.0)
     failterm.put("atrim", 949.0)
             while (failterm.size > 83) { break }



            rvListSticker
            rvListSticker.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            var jumpU:MutableList<Float> = mutableListOf<Float>()
     jumpU.add(315.0f)
     jumpU.add(815.0f)
     jumpU.add(670.0f)
     jumpU.add(179.0f)
     jumpU.add(454.0f)
     jumpU.add(786.0f)
             if (jumpU.contains(9009.0f)) {}


            rvListSticker.adapter = stickerAdapter
            var themesS:Double = 6219.0



            tvFailter1.setOnClickListener {
            var build_:Boolean = false
             if (!build_) {}


            var fragmentm:Long = 1312L
             while (fragmentm >= 150L) { break }


                avatarIdList.clear()
            var activityMb:Boolean = false
             if (!activityMb) {}


                avatarIdList.addAll(titleExtraction.failter1List)
            var closeb:Float = 5379.0f
             if (closeb >= 27.0f) {}


                createHome.notifyDataSetChanged()
            var webview4:Float = 8300.0f
             while (webview4 < 95.0f) { break }


                rvListAvatar.scrollToPosition(0)
            var itemE:Long = 687L
             if (itemE <= 32L) {}


                tvFailter2.alpha = 0.4f
            var selt:Int = 5518
             while (selt < 80) { break }


                tvFailter1.alpha = 1f
            }
            tvFailter2.setOnClickListener {
            var callbackQ:Boolean = false
             if (callbackQ) {}


            var stringsl:Int = 4549


                avatarIdList.clear()
            var aiixnN:Long = 9153L
             if (aiixnN <= 39L) {}


                avatarIdList.addAll(titleExtraction.failter2List)
            var callbackr:Double = 162.0
             if (callbackr < 46.0) {}


                createHome.notifyDataSetChanged()
            var homep:Float = 1796.0f
             if (homep >= 28.0f) {}


                rvListAvatar.scrollToPosition(0)
            var vignetteu:Int = 8079
             while (vignetteu < 77) { break }


                tvFailter1.alpha = 0.4f
            var shamodele:Boolean = false
             while (shamodele) { break }


                tvFailter2.alpha = 1f
            }

            tvSticker1.setOnClickListener {
            var backgrounde:Int = 3679
             if (backgrounde <= 120) {}


            var manifest_:MutableMap<String,String> = mutableMapOf<String,String>()
     manifest_.put("liberty", "poll")
     manifest_.put("spacer", "signals")
     manifest_.put("result", "cosqf")
     manifest_.put("apic", "alacdsp")
             if (manifest_.get("u") != null) {}


                stickerIdList.clear()
            var foreground9:MutableList<Int> = mutableListOf<Int>()
     foreground9.add(936)
     foreground9.add(924)


                stickerIdList.addAll(titleExtraction.stiker1List)
            var delete_sM:Double = 3748.0


                stickerAdapter.notifyDataSetChanged()
            var couplel:Long = 6306L
             while (couplel == 85L) { break }


                rvListSticker.scrollToPosition(0)
            var foregroundZ:MutableMap<String,Int> = mutableMapOf<String,Int>()
     foregroundZ.put("vpcc", 375)
     foregroundZ.put("bbox", 392)
     foregroundZ.put("synonym", 594)
     foregroundZ.put("contracts", 649)
             if (foregroundZ.size > 198) {}


                tvSticker2.alpha = 0.4f
            var jumpQ:Double = 4328.0
             while (jumpQ == 175.0) { break }


                tvSticker1.alpha = 1f
            }
            tvSticker2.setOnClickListener {
            var utils8:MutableList<Boolean> = mutableListOf<Boolean>()
     utils8.add(false)
     utils8.add(false)
     utils8.add(false)
     utils8.add(false)
     utils8.add(true)
             if (utils8.contains(false)) {}


            var update_84:Int = 2214
             while (update_84 == 76) { break }


                stickerIdList.clear()
            var avatarS:String = "objtxt"
             if (avatarS.length > 54) {}


                stickerIdList.addAll(titleExtraction.stiker2List)
            var buildF:Long = 3513L
             if (buildF <= 117L) {}


                stickerAdapter.notifyDataSetChanged()
            var unews0:Boolean = true
             if (unews0) {}


                rvListSticker.scrollToPosition(0)
            var gradled:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     gradled.put("named", true)
     gradled.put("reload", true)
     gradled.put("bsfs", false)
     gradled.put("preupload", false)
     gradled.put("structures", true)
             while (gradled.size > 59) { break }


                tvSticker1.alpha = 0.4f
            var hueV:MutableList<Long> = mutableListOf<Long>()
     hueV.add(37L)
     hueV.add(277L)


                tvSticker2.alpha = 1f
            }
            imgSticker.setOnClickListener {
            var bean2:MutableList<Double> = mutableListOf<Double>()
     bean2.add(443.0)
     bean2.add(947.0)
     bean2.add(678.0)
     bean2.add(136.0)
             if (bean2.size > 116) {}


            var a_titleK:Float = 4806.0f
             while (a_titleK >= 104.0f) { break }


                flAvatarBaohedu.visibility = View.GONE
            var infoq:MutableMap<String,Long> = mutableMapOf<String,Long>()
     infoq.put("mmsh", 457L)
     infoq.put("brush", 678L)
     infoq.put("cvc", 527L)
     infoq.put("textured", 799L)
     infoq.put("emoji", 500L)
             while (infoq.size > 71) { break }


                llSelAvatar.visibility = View.GONE
            var transform_kH:MutableList<Long> = mutableListOf<Long>()
     transform_kH.add(135L)
     transform_kH.add(447L)
             if (transform_kH.contains(4472L)) {}


                llSelSticker.visibility = View.VISIBLE
            var register_yn:Int = 3887
             while (register_yn == 34) { break }


                imgSticker.setImageResource(R.mipmap.sel_tiezhi)
            var t_manager0:MutableList<Long> = mutableListOf<Long>()
     t_manager0.add(960L)
     t_manager0.add(986L)
     t_manager0.add(361L)
     t_manager0.add(282L)
             if (t_manager0.contains(763L)) {}


                imgSwitchAvatar.setImageResource(R.mipmap.huantu_hei)
            var setupe:Double = 2659.0
             while (setupe == 43.0) { break }


                imgAvatarSet.setImageResource(R.mipmap.baohedu_hei)
            }
            imgSwitchAvatar.setOnClickListener {
            var backupS:Double = 9752.0


            var androidU:Float = 7204.0f
             if (androidU < 9.0f) {}


                flAvatarBaohedu.visibility = View.GONE
            var editQ:MutableMap<String,Double> = mutableMapOf<String,Double>()
     editQ.put("syncable", 869.0)
     editQ.put("trees", 706.0)
     editQ.put("mallocz", 276.0)
     editQ.put("installation", 38.0)
     editQ.put("ltable", 958.0)
     editQ.put("subtracting", 752.0)
             if (editQ.get("d") != null) {}


                llSelAvatar.visibility = View.VISIBLE
            var adjusta:Long = 3466L
             if (adjusta < 41L) {}


                llSelSticker.visibility = View.GONE
            var launcherG:Long = 9298L
             while (launcherG > 151L) { break }


                imgSticker.setImageResource(R.mipmap.nosel_tiezhi)
            var activityW:Float = 3991.0f
             while (activityW < 28.0f) { break }


                imgSwitchAvatar.setImageResource(R.mipmap.sel_tiezhi)
            var additionP:Double = 5439.0


                imgAvatarSet.setImageResource(R.mipmap.baohedu_hei)
            }
            imgAvatarSet.setOnClickListener {
            var settingsG:Boolean = true
             if (!settingsG) {}


            var gradlee:Double = 5565.0
             while (gradlee <= 177.0) { break }


                flAvatarBaohedu.visibility = View.VISIBLE
            var update_2f9:Double = 86.0
             if (update_2f9 <= 192.0) {}


                llSelAvatar.visibility = View.GONE
            var backupj:MutableList<Boolean> = mutableListOf<Boolean>()
     backupj.add(true)
     backupj.add(false)
             if (backupj.contains(true)) {}


                llSelSticker.visibility = View.GONE
            var additions:Int = 2521


                imgSticker.setImageResource(R.mipmap.nosel_tiezhi)
            var saturationP:Float = 9181.0f
             if (saturationP >= 57.0f) {}


                imgSwitchAvatar.setImageResource(R.mipmap.huantu_hei)
            var failtermT:String = "labelns"


                imgAvatarSet.setImageResource(R.mipmap.baohedu_bai)
            }
            seekBar.progress = seekBar.progress
            var aiixn_:Int = 2546
             while (aiixn_ >= 160) { break }


            seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
            var modityn:Int = 5065
             if (modityn >= 143) {}


                    if (imgAvatarBitmap == null) {
            var linear6:MutableMap<String,Int> = mutableMapOf<String,Int>()
     linear6.put("imdct", 194)
     linear6.put("each", 630)
     linear6.put("attribute", 610)
     linear6.put("icecast", 45)
     linear6.put("trex", 107)
     linear6.put("cancellation", 476)


                        imgAvatarBitmap = imgToBitMap(imgAvatar)
                    }
                    modityCenter = progress * 1.0F / 50;
            var relativeJ:String = "avigation"
             if (relativeJ == "N") {}


                    imgAvatar.setImageBitmap(
                        FilterUtil.beautyImage(
                            imgAvatarBitmap!!, 1f, modityCenter, activityManifest
                        )
                    )

                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })
            seekBarVignette.progress = seekBarVignette.progress
            var model4:Boolean = true
             if (model4) {}


            seekBarVignette.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
            var backup1:Float = 4439.0f
             if (backup1 <= 122.0f) {}


                    if (imgAvatarBitmap == null) {
            var foreground0:Long = 9280L
             while (foreground0 < 84L) { break }


                        imgAvatarBitmap = imgToBitMap(imgAvatar)
                    }

                    activityManifest = progress * 1.0F / 50;
            var curq:Int = 9800
             if (curq >= 19) {}


                    imgAvatar.setImageBitmap(
                        FilterUtil.beautyImage(
                            imgAvatarBitmap!!,
                            1f,
                            modityCenter,
                            activityManifest
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

    override fun itemClickListener(resId: Int, imageView: ImageView) {
            var livelyC:String = "ttag"


        binding.stickerView.addDecal(imgToBitMap(imageView), true, "", 0, null)
    }

    private fun ymm_savedValueEmailMipmap() {
            var colorsH:String = "providing"
             while (colorsH.length > 200) { break }


        val attrs = arguments
            var backgroundu:Long = 5501L
             if (backgroundu == 197L) {}


        if (attrs == null) {
            var createz:Double = 6983.0


            (activity as WoybuZdosDishaSaturationActivity).switchHomeFragment()
        }
        attrs?.run {
            var share_:String = "lastmbuf"


            var transform_3sP:Long = 5965L
             if (transform_3sP < 80L) {}


            type = getInt(WoybuZdosDishaRoundFrame_xEnter.biyanGradleSporty(intArrayOf(-63,-52,-59,-48,-75),0xB5,false))
            var additionsz:String = "definition"
             while (additionsz.length > 75) { break }


            avatarId = getInt(WoybuZdosDishaRoundFrame_xEnter.biyanGradleSporty(intArrayOf(-33,-56,-33,-54,-33,-52,-9,-38,-66),0xBE,false))
            var failterf:Double = 5297.0
             if (failterf < 153.0) {}



            j_androidTongAnnotationAppcompat(avatarId!!)
        }
        avatarIdList.clear()
            var recordB:Long = 7165L
             if (recordB < 67L) {}


        avatarIdList.addAll(titleExtraction.failter1List)
            var type_9yz:MutableList<Boolean> = mutableListOf<Boolean>()
     type_9yz.add(false)
     type_9yz.add(true)
     type_9yz.add(true)
     type_9yz.add(false)
             if (type_9yz.contains(true)) {}


        createHome.setAvatarId(avatarId!!)
            var jianbiansew:Long = 6839L
             while (jianbiansew < 161L) { break }


        createHome.notifyDataSetChanged()
            var failterS:Int = 1917
             while (failterS > 125) { break }


        stickerIdList.clear()
            var vinit_s71:Float = 9383.0f


        stickerIdList.addAll(titleExtraction.stiker1List)
            var shamodel3:Double = 1052.0
             if (shamodel3 >= 3.0) {}


        stickerAdapter.notifyDataSetChanged()
    }
}