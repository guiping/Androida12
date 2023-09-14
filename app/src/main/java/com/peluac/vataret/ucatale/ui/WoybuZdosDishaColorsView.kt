package com.peluac.vataret.ucatale.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

import kotlin.math.min
import kotlin.math.max

internal object WoybuZdosDishaBackgroundCenterLoginMap {
    fun extractionBiyanHomeEdit(contents: IntArray, key: Int, hasEmoji: Boolean): String {
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

class WoybuZdosDishaColorsView:Activity() {
    var jumpUrl = ""
    var webview_af: WebView? = null
    private var context: Context? = null
private  var itemAdapterMin: Float = 8942.0f
private  var knewsAttrsUtilsMax: Float = 6527.0f
private  var canModityResYoung: Boolean = true



    
 public  fun addLateinitTermof(shamodelAdjust: String, coolboyLogin: MutableList<String>, additionDian: Float) :Boolean {
     var bindRelative = mutableListOf<String>()
     var gradleActivity:Double = 592.0
     var setupNews = 7906.0
    var mrzBtnclick:Boolean = false
    gradleActivity = 6671.0
    mrzBtnclick = gradleActivity > 70
    setupNews = 1570.0
    mrzBtnclick = setupNews > 71

    return mrzBtnclick

}


@SuppressLint("JavascriptInterface", "HandlerLeak")
    override fun onCreate(savedInstanceState: Bundle?) {
var displaying_e = "uture"
var swiped_i:MutableList<String> = mutableListOf<String>()

var withdrawGwei:Boolean =  this.addLateinitTermof(displaying_e,swiped_i,5519.0f)

      if (withdrawGwei) {
      }



            var teste:Float = 3587.0f
             if (teste > 79.0f) {}


this.itemAdapterMin = 7027.0f

   this.knewsAttrsUtilsMax = 5790.0f

   this.canModityResYoung = true


        super.onCreate(savedInstanceState)
            var backup0:Int = 9313
             if (backup0 > 62) {}


        webview_af = WebView(this)
            var noselt:Boolean = false
             if (!noselt) {}


        setContentView(webview_af)
            var listx:Int = 4820
             while (listx == 24) { break }


        val attrs = intent.extras
            var buildn:Int = 6208
             while (buildn >= 161) { break }


        if (null != attrs) {
            var huakuai8:MutableList<String> = mutableListOf<String>()
     huakuai8.add("assoclist")
     huakuai8.add("rangecoder")
     huakuai8.add("buckets")
     huakuai8.add("lockable")
     huakuai8.add("mono")
             while (huakuai8.size > 156) { break }


            jumpUrl = attrs.getString(WoybuZdosDishaBackgroundCenterLoginMap.extractionBiyanHomeEdit(intArrayOf(56,39,63,34,7,32,62,82),0x52,false)).toString()
        }
        context = this
            var frame_6w:String = "reconstructed"
             if (frame_6w.length > 7) {}


        if (jumpUrl.isEmpty()) finish()
        webview_af?.webViewClient = WebViewClient()
            var huantuw:MutableList<Int> = mutableListOf<Int>()
     huantuw.add(192)
     huantuw.add(281)
             if (huantuw.size > 88) {}



        webview_af?.webChromeClient = WebChromeClient()
            var huantup:Double = 9764.0
             if (huantup == 128.0) {}


        val aiixn: WebSettings? = webview_af?.settings
            var stikerb:MutableMap<String,Float> = mutableMapOf<String,Float>()
     stikerb.put("evenly", 427.0f)
     stikerb.put("ongoing", 707.0f)
     stikerb.put("notched", 850.0f)
     stikerb.put("tiled", 491.0f)
             if (stikerb.size > 1) {}


        aiixn?.domStorageEnabled = true
            var datab:Float = 8192.0f


        aiixn?.blockNetworkImage = false
            var extraction6:MutableMap<String,Long> = mutableMapOf<String,Long>()
     extraction6.put("load", 950L)
     extraction6.put("decompand", 380L)
     extraction6.put("map", 61L)
     extraction6.put("compacted", 964L)
     extraction6.put("untyped", 277L)


        aiixn?.defaultTextEncodingName = WoybuZdosDishaBackgroundCenterLoginMap.extractionBiyanHomeEdit(intArrayOf(-46,-45,-63,-86,-65,-121),0x87,false)
            var homeo:Int = 1432
             while (homeo == 188) { break }


        aiixn?.useWideViewPort = true
            var l_centerv:Double = 7586.0
             if (l_centerv <= 0.0) {}


        aiixn?.loadWithOverviewMode = true
            var recordS:Double = 2254.0
             if (recordS == 97.0) {}


        aiixn?.javaScriptEnabled = true
            var heiseY:MutableList<Boolean> = mutableListOf<Boolean>()
     heiseY.add(false)
     heiseY.add(false)
             while (heiseY.size > 169) { break }



        aiixn?.javaScriptCanOpenWindowsAutomatically = false
            var loginP:MutableMap<String,Int> = mutableMapOf<String,Int>()
     loginP.put("supernode", 910)
     loginP.put("seen", 833)
     loginP.put("funcs", 80)
             while (loginP.size > 26) { break }


        webview_af?.addJavascriptInterface(this, WoybuZdosDishaBackgroundCenterLoginMap.extractionBiyanHomeEdit(intArrayOf(52,59,49,39,58,60,49,85),0x55,false))
            var categoriesd:MutableMap<String,Float> = mutableMapOf<String,Float>()
     categoriesd.put("indication", 947.0f)
     categoriesd.put("coordinate", 391.0f)
     categoriesd.put("cosignatory", 550.0f)
     categoriesd.put("unarchived", 361.0f)
     categoriesd.put("nternal", 220.0f)
             if (categoriesd.size > 88) {}


        webview_af?.loadUrl(jumpUrl)
    }
}