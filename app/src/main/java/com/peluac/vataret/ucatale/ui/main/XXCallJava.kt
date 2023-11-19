package com.peluac.vataret.ucatale.ui.main

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.ActivityInfo
import android.provider.Settings
import android.util.Log
import android.webkit.JavascriptInterface
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustAttribution
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.AdjustEvent
import com.adjust.sdk.OnAttributionChangedListener
import org.json.JSONException
import org.json.JSONObject


class XXCallJava(val activity: Activity) {
    @JavascriptInterface
    fun callJava(method: String, dataJson: String): String? {
        Log.e("pLog", "callJava --- method = $method ----- dataJson = $dataJson")
        //根据method参数处理不同事件
        when (method) {
            "getPackageName" -> {// 获取包名
                getPackageName(dataJson)
            }

            "getDeviceId" -> {
                getAndroidID()
            }

            "setOrientation" -> { //切换横竖屏
                setOrientation(dataJson)
            }

            "getAdJustKey" -> {
                getAdJustKey(dataJson)
            }

            "copyToClipBoard" -> {
                copyToClipBoard(dataJson)
            }

            "adjustlogEvent" -> {
                adjustlogEvent(dataJson)
            }


            else -> Log.e("pLog", "callJava error, methon: $method")
        }
        // 有返回值时返回具体数据，没有时返回空字符串
        return ""
    }

    private fun getPackageName(dataJson: String?): String? {
        // 内部等待实现
        return activity?.packageName
    }

    private fun getAndroidID(): String? {
        // 内部等待实现
        val androidId =
            Settings.Secure.getString(activity.contentResolver, Settings.Secure.ANDROID_ID);
        return androidId
    }

    private fun setOrientation(dataJson: String?): String? {
        val json = JSONObject(dataJson)
        val dir = json.getString("dir")
        activity?.let {
            it.runOnUiThread(Runnable {
                if (dir == "V") {
                    it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                } else {
                    it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                }
            })
        }

        return ""
    }

    //复制到粘贴板
    fun copyToClipBoard(strJson: String?) {
        //insert code
        try {
            val json = JSONObject(strJson)
            val content = json.getString("content")
            activity.let {
                it.runOnUiThread(Runnable {
                    val myClipboard: ClipboardManager =
                        it.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    myClipboard.text = content
                })
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun adjustlogEvent(dataJson: String) {
        val json = JSONObject(dataJson)
        val tObjData = json.getString("tObjData")
        val tCurrencyType = json.getString("tCurrencyType")
        val typetoken = json.getString("typetoken")
        val adjustEvent = AdjustEvent(typetoken)
        if (tCurrencyType != "") {
            adjustEvent.setRevenue(java.lang.Double.valueOf(tObjData), tCurrencyType)
        }
        Adjust.trackEvent(adjustEvent)
    }

    var AdjustData: String = ""

    private fun registerAdjustAttributionChanged() {
        val environment: String = AdjustConfig.ENVIRONMENT_PRODUCTION
        val config = AdjustConfig(activity, "adjust_key", environment)
        config.setUrlStrategy(AdjustConfig.URL_STRATEGY_CHINA)
        config.setOnAttributionChangedListener { attribution ->
            val mJsonobjData = JSONObject()
            mJsonobjData.put("trackerName", attribution.trackerName)
            mJsonobjData.put("trackerToken", attribution.trackerToken)
            mJsonobjData.put("adid", attribution.adid)
            mJsonobjData.put("clickLabel", attribution.clickLabel)
            AdjustData = "" + mJsonobjData.toString()
        }
    }

    private fun getAdJustKey(dataJson: String): String? {
        return AdjustData
    }
}