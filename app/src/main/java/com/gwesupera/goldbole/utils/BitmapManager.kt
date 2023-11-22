package com.gwesupera.goldbole.utils

import android.graphics.Bitmap

object BitmapManager {
    var bitmapMap: HashMap<String, Bitmap> = HashMap()
    fun setBitmap(key: String, bitmap: Bitmap) {
        bitmapMap[key] = bitmap
    }

    fun getBitmap(key: String): Bitmap? = bitmapMap[key]
}