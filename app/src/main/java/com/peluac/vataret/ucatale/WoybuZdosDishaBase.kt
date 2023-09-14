package com.peluac.vataret.ucatale

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import org.json.JSONObject
import java.util.*
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

import kotlin.math.min
import kotlin.math.max

internal object WoybuZdosDishaCountLumColorsShare {
    fun enterBottomBiyanSettings(contents: IntArray, key: Int, hasEmoji: Boolean): String {
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

class WoybuZdosDishaBase:Application() {
    private val manifestYouth = WoybuZdosDishaCountLumColorsShare.enterBottomBiyanSettings(intArrayOf(-98,-121,-111,-49,-60,-69,-61,-103,-59,-67,-82,-93,-61,-121,-80,-116,-78,-82,-125,-101,-73,-75,-10),0xF6,false)
 var likeSelChoose_tag: Long = 6250L
 var enbale_TouxiangVignetteSaturation: Boolean = false


    
private fun coolMenghuanRunnerNetwork() :Int {
     var livelyVignette = "payee"
     var transform_kfGradle:String = "fint"
     var gradleHue = 7914
    var nodesetSpatial:Int = 5775
    gradleHue = gradleHue
    nodesetSpatial -= gradleHue

    return nodesetSpatial

}


override fun onCreate() {

var lowbdSubsamp:Int =  this.coolMenghuanRunnerNetwork()

      println(lowbdSubsamp)



            var rules2:Double = 4043.0
             while (rules2 > 54.0) { break }


this.likeSelChoose_tag = 9739L

   this.enbale_TouxiangVignetteSaturation = false


        super.onCreate()
            var huantuK:Int = 659
             while (huantuK >= 158) { break }


        AppsFlyerLib.getInstance().setDebugLog(true)
            var manifestR:MutableMap<String,Int> = mutableMapOf<String,Int>()
     manifestR.put("openmpt", 597)
     manifestR.put("evenavg", 353)
     manifestR.put("twostage", 732)
     manifestR.put("negotiated", 830)
     manifestR.put("stoped", 658)
     manifestR.put("write", 516)
             if (manifestR.size > 148) {}


        AppsFlyerLib.getInstance().init(
            manifestYouth,
            object : AppsFlyerConversionListener {
                
private fun scrollRoundHolder() :Int {
     var register_jCartoon:Float = 1786.0f
     var instrumentedData:Int = 1701
     var relativeCoolboy = false
     var stikerCallback:Boolean = false
    var winceBegun:Int = 9736
    register_jCartoon += register_jCartoon
    instrumentedData = 493
    winceBegun -= instrumentedData
    relativeCoolboy = true
    winceBegun += if(relativeCoolboy) 76 else 26
    stikerCallback = true
    winceBegun *= if(stikerCallback) 4 else 5

    return winceBegun

}


override fun onConversionDataSuccess(conversionData: Map<String?, Any?>) {

var testbitCheck:Int =  this.scrollRoundHolder()

   if (testbitCheck > 0) {
      for (e_5 in 0 .. testbitCheck) {
          if (e_5 == 2) {
              println(e_5)
              break
          }
      }
  }




                }

                
private fun useTextHqg(exampleItem: MutableList<Boolean>, modelThemes: Float, dataStiler: Long) :MutableMap<String,Double> {
     var imgModel = 7633.0
     var sportyFailter:String = "jacosub"
     var register_nsStiker:Int = 5995
    var rewriterSavestate = mutableMapOf<String,Double>()
         rewriterSavestate.put("qualify", 386.0)
     rewriterSavestate.put("bulk", 687.0)
     rewriterSavestate.put("sched", 210.0)
     rewriterSavestate.put("enumerate", 203.0)
     rewriterSavestate.put("defines", 393.0)
     rewriterSavestate.put("differ", 554.0)
    imgModel = 9460.0
    rewriterSavestate.put("rotateInstallsSessions", imgModel)
    register_nsStiker = 6453
    rewriterSavestate.put("catchableMpchuff", 6655.0)

    return rewriterSavestate

}


override fun onConversionDataFail(errorMessage: String) {
var doall_y = mutableListOf<Boolean>()

var aybriQuantity =  this.useTextHqg(doall_y,1166.0f,529L)

      for(object_e in aybriQuantity) {
          println(object_e.key)
          println(object_e.value)
      }
      var aybriQuantity_len:Int = aybriQuantity.size




                }

                
private fun strokeDialogCompanion() :Long {
     var listCur = mutableListOf<String>()
     var infoBiyan = 1560.0
     var mapObserver:MutableList<Int> = mutableListOf<Int>()
     var stikerGradle:Long = 4594L
    var transportsFpc:Long = 3681L
    infoBiyan -= 6550.0
    stikerGradle = 1134L
    transportsFpc += stikerGradle

    return transportsFpc

}


override fun onAppOpenAttribution(attributionData: Map<String?, String?>?) {

var nhanceRealtext =  this.strokeDialogCompanion()

      if (nhanceRealtext < 70L) {
             println(nhanceRealtext)
      }
      var nhanceRealtext_filter: Int = nhanceRealtext.toInt()


}
                
private fun finishWhenTranslateCodeTestStorage(xiaoCoolboy: Long) :String {
     var androidTitle = mutableListOf<Double>()
     var settingsData:MutableList<Boolean> = mutableListOf<Boolean>()
     var colorsUtils:MutableMap<String,Int> = mutableMapOf<String,Int>()
     var itemNosel = 851
 var tackEntry = "colskip"
    if (itemNosel <= 128 && itemNosel >= -128){
    var load_i = min(1, kotlin.random.Random.nextInt(28)) % tackEntry.length
        tackEntry += itemNosel.toString()
    }

    return tackEntry

}


override fun onAttributionFailure(errorMessage: String) {

var initialsVoicemail =  this.finishWhenTranslateCodeTestStorage(7576L)

      if (initialsVoicemail == "biyan") {
              println(initialsVoicemail)
      }
      var initialsVoicemail_len = initialsVoicemail.length




                }
            },
            this
        )
        AppsFlyerLib.getInstance().start(this)
    }
}