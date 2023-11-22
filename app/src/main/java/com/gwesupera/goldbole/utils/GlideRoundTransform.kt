package com.gwesupera.goldbole.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest

class GlideRoundTransform @JvmOverloads constructor(context: Context?, dp: Int = 10) :
    BitmapTransformation() {
    init {
        radius = Resources.getSystem().displayMetrics.density * dp
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        return roundCrop(pool, toTransform)!!
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {}

    companion object {
         var radius = 10f
        private fun roundCrop(pool: BitmapPool, source: Bitmap?): Bitmap? {
            if (source == null) return null
            var result: Bitmap? = pool[source.width, source.height, Bitmap.Config.ARGB_8888]
            if (result == null) {
                result = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
            }
            val canvas = Canvas(result!!)
            val paint = Paint()
            paint.shader =
                BitmapShader(source, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
            paint.isAntiAlias = true
            val rectF = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
            canvas.drawRoundRect(rectF, radius, radius, paint)
            return result
        }
    }
}