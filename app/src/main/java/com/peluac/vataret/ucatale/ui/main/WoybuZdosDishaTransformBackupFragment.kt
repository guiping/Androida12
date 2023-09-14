package com.peluac.vataret.ucatale.ui.main

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
import com.peluac.vataret.ucatale.WoybuZdosDishaColorsSetupActivity
import com.peluac.vataret.ucatale.databinding.WoybuzdosdishaApplicationSheetBinding
import com.peluac.vataret.ucatale.observer.WoybuZdosDishaHandsome
import com.peluac.vataret.ucatale.view.SShapeFrameLayout
import com.peluac.vataret.ucatale.view.SShapeModel
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

import kotlin.math.min
import kotlin.math.max

internal object WoybuZdosDishaUtilTest {
    fun youngCloseStiker(contents: IntArray, key: Int, hasEmoji: Boolean): String {
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

class WoybuZdosDishaTransformBackupFragment : Fragment() {
    val binding: WoybuzdosdishaApplicationSheetBinding by lazy {
            var sheet7:Float = 3989.0f
             if (sheet7 > 113.0f) {}


        WoybuzdosdishaApplicationSheetBinding.inflate(layoutInflater)
    }
    var curSelShapeModel: SShapeModel? = null
    var curSelLayout: SShapeFrameLayout? = null
    var curAvatarId: Int = 0
    private val instrumentedGradle by lazy {
            var glidel:Float = 1276.0f
             while (glidel > 166.0f) { break }


        arrayListOf(
            binding.flSporty1,
            binding.flSporty2,
            binding.flSporty3,
            binding.flSporty4,
            binding.flSporty5
        )
    }
    private val aiixnCur by lazy {
            var lumB:Double = 6504.0


        arrayListOf(
            binding.flHandsome1,
            binding.flHandsome2,
            binding.flHandsome3,
            binding.flHandsome4,
            binding.flHandsome5
        )
    }
    private val gradlewLogin by lazy {
            var youthL:Double = 4863.0


        arrayListOf(
            binding.flCoolBoy1,
            binding.flCoolBoy2,
            binding.flCoolBoy3,
            binding.flCoolBoy4,
            binding.flCoolBoy5
        )
    }
    private val biyanListener by lazy {
            var bitmapU:Long = 5243L
             while (bitmapU <= 29L) { break }


        arrayListOf(
            binding.flYoungBoy1,
            binding.flYoungBoy2,
            binding.flYoungBoy3,
            binding.flYoungBoy4,
            binding.flYoungBoy5
        )
    }

    private val applicationFragment by lazy {
            var shamodelT:Boolean = false
             while (!shamodelT) { break }


        arrayListOf(
            binding.imgSporty1,
            binding.imgSporty2,
            binding.imgSporty3,
            binding.imgSporty4,
            binding.imgSporty5
        )
    }
    private val arrowCur by lazy {
            var fangdasuoxiaoH:MutableList<Long> = mutableListOf<Long>()
     fangdasuoxiaoH.add(183L)
     fangdasuoxiaoH.add(158L)
             if (fangdasuoxiaoH.size > 137) {}


        arrayListOf(
            binding.imgHandsome1,
            binding.imgHandsome2,
            binding.imgHandsome3,
            binding.imgHandsome4,
            binding.imgHandsome5
        )
    }
    private val roundExtraction by lazy {
            var fragmentn:Int = 7710
             while (fragmentn <= 200) { break }


        arrayListOf(
            binding.imgCoolBoy1,
            binding.imgCoolBoy2,
            binding.imgCoolBoy3,
            binding.imgCoolBoy4,
            binding.imgCoolBoy5
        )
    }
    private val aiixnSaturation by lazy {
            var bitmapF:Int = 5054
             if (bitmapF == 101) {}


        arrayListOf(
            binding.youngBoy1,
            binding.youngBoy2,
            binding.youngBoy3,
            binding.youngBoy4,
            binding.youngBoy5
        )
    }

    companion object {
        fun newInstance() = WoybuZdosDishaTransformBackupFragment()
    }

    private lateinit var titleExtraction: WoybuZdosDishaListener
private  var clickDianFailterFlag: Long = 4953L
private  var countHandsomeBaiseDictionary: MutableMap<String,Double> = mutableMapOf<String,Double>()



    
private fun dismissFeedbackOutputRegistry(glideFangdasuoxiao: String, setupFailter: Long) :MutableList<Int> {
     var themesBuild = 1237
     var roundedSporty:MutableList<Float> = mutableListOf<Float>()
     var frame_50Bean = true
    var nvencRtmppktMfra = mutableListOf<Int>()
    themesBuild = 5748
      var dialog_len1:Int = nvencRtmppktMfra.size
    var k_title_s = min(kotlin.random.Random.nextInt(40), 1) % max(1, nvencRtmppktMfra.size)
    nvencRtmppktMfra.add(k_title_s, themesBuild)

    return nvencRtmppktMfra

}


private fun bvz_viewNoselFromBeanBaiseFlags(flLayout: SShapeFrameLayout) {
var delegate_x_d:String = "archived"

var hevcpredRefining:MutableList<Int> =  this.dismissFeedbackOutputRegistry(delegate_x_d,252L)

      var hevcpredRefining_len:Int = hevcpredRefining.size
      for(obj4 in hevcpredRefining) {
          println(obj4)
      }



            var categoriesi:Float = 6122.0f
             if (categoriesi < 185.0f) {}


        curSelShapeModel?.strokeColorCenter = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(-86,-71,-71,-71,-71,-71,-71,-71,-71,-119),0x89,false))
            var correct8:Int = 8791
             if (correct8 < 97) {}


        curSelShapeModel?.strokeColorEnd = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(79,92,92,92,92,92,92,92,92,108),0x6C,false))
            var vignetteC:MutableMap<String,Boolean> = mutableMapOf<String,Boolean>()
     vignetteC.put("colons", true)
     vignetteC.put("brace", false)
             if (vignetteC.get("R") != null) {}


        curSelShapeModel?.strokeColorStart = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(51,32,32,32,32,32,32,32,32,16),0x10,false))
            var bottomp:Double = 8754.0
             while (bottomp < 49.0) { break }


        curSelLayout?.setShapeModel(curSelShapeModel!!)
            var dianM:Int = 1996
             while (dianM < 10) { break }


        curSelLayout = null
            var settingsI:Float = 3992.0f
             while (settingsI <= 144.0f) { break }


        curSelShapeModel = null
            var cartoone:MutableMap<String,String> = mutableMapOf<String,String>()
     cartoone.put("latency", "zoomable")
     cartoone.put("parentheses", "essage")
     cartoone.put("expiry", "statep")


        val info = flLayout.getShapeModel()
            var saturationz:Float = 6232.0f
             while (saturationz < 81.0f) { break }


        info.strokeColorCenter = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(-82,-53,-53,-53,-53,-53,-53,-115),0x8D,false))
            var class_2L:Double = 6783.0
             while (class_2L >= 147.0) { break }


        info.strokeColorEnd = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(46,75,75,75,75,75,75,13),0xD,false))
            var main_cK:MutableMap<String,String> = mutableMapOf<String,String>()
     main_cK.put("forced", "sigpass")
     main_cK.put("unwritable", "eating")
             while (main_cK.size > 146) { break }


        info.strokeColorStart = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(-20,-119,-119,-119,-119,-119,-119,-49),0xCF,false))
            var stikerC:Long = 8688L
             while (stikerC > 162L) { break }


        flLayout.setShapeModel(info)
            var vignette7:MutableMap<String,Int> = mutableMapOf<String,Int>()
     vignette7.put("ftvmlastnode", 839)
     vignette7.put("ensure", 48)
             while (vignette7.size > 131) { break }


        curSelLayout = flLayout
            var observer4:String = "reinit"
             if (observer4.length > 121) {}


        curSelShapeModel = info
    }

    
private fun targetBaiseYoungLikeOverviewChange() :Int {
     var transform_fGradle:String = "ftvfolderclosed"
     var listenerBottom = mutableMapOf<String,Long>()
     var webviewHolder = 2901L
    var finalPniels:Int = 3753
    webviewHolder *= 6233L

    return finalPniels

}


override fun onCreate(savedInstanceState: Bundle?) {

var simulatorOrientation:Int =  this.targetBaiseYoungLikeOverviewChange()

      println(simulatorOrientation)



            var logind:MutableMap<String,Double> = mutableMapOf<String,Double>()
     logind.put("clazz", 202.0)
     logind.put("slider", 656.0)
     logind.put("removable", 517.0)
     logind.put("encap", 198.0)
     logind.put("autoremove", 107.0)
             while (logind.size > 193) { break }


        super.onCreate(savedInstanceState)
            var layoutS:Long = 4675L
             while (layoutS > 120L) { break }


        titleExtraction = ViewModelProvider(this)[WoybuZdosDishaListener::class.java]
    }


    
private fun selectUtilVisible(roundActivity: Double, bindBuild: Float, callbackHome: String) :Double {
     var stickerContext:String = "tsan"
     var backupLively:Int = 7255
     var backupFrame_6 = 9764L
    var varwidthStripReflector:Double = 8421.0
    backupLively = backupLively
    backupFrame_6 = 6873L

    return varwidthStripReflector

}


override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
var excluding_f = "redirectional"

var ethProfiles =  this.selectUtilVisible(7476.0,1809.0f,excluding_f)

      if (ethProfiles >= 14.0) {
             println(ethProfiles)
      }



            var keyk:Long = 1603L
             while (keyk == 122L) { break }


        nm_inflateFullLazyTermofView()
            var homef:Boolean = true
             while (!homef) { break }


        ymm_savedValueEmailMipmap()
            var livelyN:Long = 3515L
             while (livelyN >= 138L) { break }


        return binding.root
    }

    
private fun solidBumptechVataretResource(managerJump: Float) :Boolean {
     var urlXiao = mutableMapOf<String,String>()
     var webviewHue = mutableListOf<String>()
     var centerItem:Float = 8573.0f
    var axisSpecific:Boolean = false
    centerItem = 4642.0f
    axisSpecific = centerItem > 60

    return axisSpecific

}


private fun ymm_savedValueEmailMipmap() {

var gdprUnconsumed:Boolean =  this.solidBumptechVataretResource(4394.0f)

      if (!gdprUnconsumed) {
      }



            var dianC:MutableList<String> = mutableListOf<String>()
     dianC.add("ios")
     dianC.add("appears")
     dianC.add("oggvorbis")
     dianC.add("address")


this.clickDianFailterFlag = 4987L

   this.countHandsomeBaiseDictionary = mutableMapOf<String,Double>()


        for ((index, value) in titleExtraction.sportyAvatarList.withIndex()) {
            var foregroundG:MutableMap<String,Long> = mutableMapOf<String,Long>()
     foregroundG.put("warning", 828L)
     foregroundG.put("planes", 368L)
             if (foregroundG.get("F") != null) {}


            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(applicationFragment[index])
        }
        for ((index, value) in titleExtraction.handsomeAvatarList.withIndex()) {
            var fnewsR:Float = 5938.0f
             while (fnewsR <= 59.0f) { break }


            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(arrowCur[index])
        }
        for ((index, value) in titleExtraction.coolBoyAvatarList.withIndex()) {
            var stilerK:Long = 6955L
             while (stilerK > 11L) { break }


            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(roundExtraction[index])
        }
        for ((index, value) in titleExtraction.youngBoyAvatarList.withIndex()) {
            var stringsI:Long = 6311L
             while (stringsI == 43L) { break }


            Glide.with(this).asBitmap().load(value).apply(
                RequestOptions.bitmapTransform(
                    CircleCrop()
                )
            ).into(aiixnSaturation[index])
        }
    }

    
private fun imageNqnUri() :Boolean {
     var huakuaiCur:MutableList<String> = mutableListOf<String>()
     var modityHome = mutableListOf<Long>()
     var shareData:Long = 9873L
    var bcduintScenario:Boolean = false
    shareData += 816L
    bcduintScenario = shareData > 0

    return bcduintScenario

}


private fun nm_inflateFullLazyTermofView() {

var mcompYear:Boolean =  this.imageNqnUri()

      if (!mcompYear) {
          println("ok")
      }



            var adapterM:Int = 9681
             if (adapterM >= 120) {}



        binding.run {
            var themesA:MutableMap<String,String> = mutableMapOf<String,String>()
     themesA.put("acquired", "unavailabe")
     themesA.put("determinable", "hrss")
     themesA.put("autorotation", "pushing")
     themesA.put("incremental", "severity")
     themesA.put("simpletag", "cancell")
     themesA.put("pretwiddle", "return")
             if (themesA.get("v") != null) {}


            imgBack.setOnClickListener {
            var dataJ:String = "trans"
             if (dataJ.length > 180) {}


            var listenerD:MutableList<Boolean> = mutableListOf<Boolean>()
     listenerD.add(false)
     listenerD.add(true)

  
                (activity as WoybuZdosDishaColorsSetupActivity).closeActivity()
            }
            flLayoutCouple.setOnClickListener {
            var bitmapd:Int = 2060
             while (bitmapd > 192) { break }


            var a_centerZ:Boolean = false
             while (a_centerZ) { break }

  
                
                WoybuZdosDishaHandsome.updateCallback(curAvatarId)
                (activity as WoybuZdosDishaColorsSetupActivity).closeActivity()
            }

            curAvatarId = titleExtraction.sportyAvatarList[0]
            var themese:Float = 9435.0f
             if (themese > 85.0f) {}


            curSelLayout = instrumentedGradle[0]
            var local_ap:Boolean = true
             while (local_ap) { break }


            curSelShapeModel = curSelLayout?.getShapeModel()
            var dialogX:MutableMap<String,Double> = mutableMapOf<String,Double>()
     dialogX.put("freeze", 589.0)
     dialogX.put("nullableresolved", 126.0)
     dialogX.put("perf", 217.0)


            curSelShapeModel?.strokeColorCenter = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(-23,-116,-116,-116,-116,-116,-116,-54),0xCA,false))
            var additionJ:Long = 5319L
             if (additionJ < 22L) {}


            curSelShapeModel?.strokeColorStart = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(-16,-107,-107,-107,-107,-107,-107,-45),0xD3,false))
            var arrowS:Boolean = true
             while (!arrowS) { break }


            curSelShapeModel?.strokeColorEnd = Color.parseColor(WoybuZdosDishaUtilTest.youngCloseStiker(intArrayOf(90,63,63,63,63,63,63,121),0x79,false))
            var attrsK:Float = 2150.0f
             while (attrsK > 108.0f) { break }


            curSelLayout?.setShapeModel(curSelShapeModel!!)
            var colors6:MutableList<String> = mutableListOf<String>()
     colors6.add("sqliterebaser")
     colors6.add("localization")
             if (colors6.size > 176) {}



            for ((index, value) in instrumentedGradle.withIndex()) {
            var boyA:Float = 8363.0f
             if (boyA == 172.0f) {}


                value.setOnClickListener {
            var relativeH:Int = 4936
             while (relativeH == 60) { break }


                    bvz_viewNoselFromBeanBaiseFlags(value)
            var n_centerV:Double = 5548.0
             if (n_centerV >= 123.0) {}


                    curAvatarId = titleExtraction.sportyAvatarList[index]
                }
            }
            for ((index, value) in aiixnCur.withIndex()) {
            var extractiond:MutableList<String> = mutableListOf<String>()
     extractiond.add("gutter")
     extractiond.add("yuvya")
             if (extractiond.size > 177) {}


                value.setOnClickListener {
            var stikerY:MutableMap<String,String> = mutableMapOf<String,String>()
     stikerY.put("magy", "wdlfcn")
     stikerY.put("exif", "unbind")
     stikerY.put("scrolled", "graphics")
     stikerY.put("semantic", "separator")
             while (stikerY.size > 58) { break }


                    bvz_viewNoselFromBeanBaiseFlags(value)
            var adapterK:Boolean = true
             if (!adapterK) {}


                    curAvatarId = titleExtraction.handsomeAvatarList[index]
                }
            }
            for ((index, value) in gradlewLogin.withIndex()) {
            var noselh:MutableList<Float> = mutableListOf<Float>()
     noselh.add(56.0f)
     noselh.add(172.0f)
     noselh.add(657.0f)
     noselh.add(998.0f)
     noselh.add(286.0f)
             if (noselh.size > 107) {}


                value.setOnClickListener {
            var listY:Int = 8444


                    bvz_viewNoselFromBeanBaiseFlags(value)
            var sel7:MutableMap<String,Long> = mutableMapOf<String,Long>()
     sel7.put("cronos", 169L)
     sel7.put("digestbyname", 137L)


                    curAvatarId = titleExtraction.coolBoyAvatarList[index]
                }
            }
            for ((index, value) in biyanListener.withIndex()) {
            var activityd:Boolean = true
             if (!activityd) {}


                value.setOnClickListener {
            var testi:String = "animals"
             while (testi.length > 124) { break }


                    bvz_viewNoselFromBeanBaiseFlags(value)
            var unitG:Long = 4433L
             while (unitG > 144L) { break }


                    curAvatarId = titleExtraction.youngBoyAvatarList[index]
                }
            }

        }
    }

}