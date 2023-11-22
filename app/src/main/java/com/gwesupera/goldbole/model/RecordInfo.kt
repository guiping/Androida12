package com.gwesupera.goldbole.model

import android.graphics.Bitmap
import java.io.Serializable

/**
 * create by ping at 2023/9/12
 */
class RecordInfo : Serializable {
    var coupleBitmap: Bitmap? = null
    var coupleBitmapUri: String? = null
    var time: String? = null
}