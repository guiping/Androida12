package com.peluac.vataret.ucatale

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import org.json.JSONObject
import java.util.*

class A02Application:Application() {
    private val afKey = "hqg92M5o3KXU5qFzDXumAC"
    override fun onCreate() {
        super.onCreate()
//        AppsFlyerLib.getInstance().setDebugLog(true)
//        AppsFlyerLib.getInstance().init(
//            afKey,
//            object : AppsFlyerConversionListener {
//                override fun onConversionDataSuccess(conversionData: Map<String?, Any?>) {
//
//                }
//
//                override fun onConversionDataFail(errorMessage: String) {
//
//                }
//
//                override fun onAppOpenAttribution(attributionData: Map<String?, String?>?) {}
//                override fun onAttributionFailure(errorMessage: String) {
//
//                }
//            },
//            this
//        )
//        AppsFlyerLib.getInstance().start(this)
    }
}
