package com.peluac.vataret.ucatale.utils

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast


import java.io.File
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*

object FilterUtil {
    fun negativeBitmap(
        bm: Bitmap?,
        frame: Bitmap?,
        frameText: Bitmap?,
        fourBitMao: Bitmap?
    ): Bitmap? {
        if (bm == null) return null
        val w = bm.width
        val h = bm.height
        val newBM = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(newBM)
        if (bm != null) {
            val bg = Bitmap.createScaledBitmap(bm, w, h, true)
            canvas.drawBitmap(bg, 0f, 0f, null)
        }
        if (frame != null) {
            val sizeFrame = Bitmap.createScaledBitmap(frame, w, h, true)
            canvas.drawBitmap(sizeFrame, 0f, 0f, null)
        }
        if (frameText != null) canvas.drawBitmap(frameText, 0f, 0f, null)
        if (fourBitMao != null) {
            canvas.drawBitmap(fourBitMao, 0f, 0f, null)
        }
        return newBM
    }

    @SuppressLint("SimpleDateFormat")
    fun save(context: Context, image: Bitmap, type: Int): Uri? {
        if (image.isRecycled) {
            Toast.makeText(context, "Save successfully", Toast.LENGTH_SHORT).show()
            return null
        }

        val mImageTime = System.currentTimeMillis()
        val imageDate = SimpleDateFormat("yyyyMMdd-HHmmss").format(Date(mImageTime))
        val SCREENSHOT_FILE_NAME_TEMPLATE = "image_%s.png"
        val mImageFileName = String.format(SCREENSHOT_FILE_NAME_TEMPLATE, imageDate)
        val values = ContentValues()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            values.put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES + File.separator + "image"
            )
        }
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, mImageFileName)
        values.put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
        values.put(MediaStore.MediaColumns.DATE_ADDED, mImageTime / 1000)
        values.put(MediaStore.MediaColumns.DATE_MODIFIED, mImageTime / 1000)
        val resolver = context.contentResolver
        val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        var out: OutputStream? = null
        try {
            out = resolver.openOutputStream(uri!!)
            if (out != null) {
                image.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            if (type == 0)
                Toast.makeText(context, "Save successfully", Toast.LENGTH_SHORT).show()
            image.recycle()

        } catch (e: IOException) {
            e.printStackTrace()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                resolver.delete(uri!!, null)
            }
            return null
        } finally {
            try {
                out?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        var recordInfo = com.peluac.vataret.ucatale.model.RecordInfo()
        recordInfo.coupleBitmapUri = uri?.toString()
        if (type == 1) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            if (uri != null) {
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
                shareIntent.type = "image/*"
            } else {
                shareIntent.type = "text/plain"
            }
            context.startActivity(Intent.createChooser(shareIntent, ""))
        }
        return uri
    }


    fun beautyImage(srcBitmap: Bitmap, rotate: Float, saturation: Float, scale: Float): Bitmap {
        //调整色相
        val rotateMatrix = ColorMatrix()
        rotateMatrix.setRotate(0, rotate)
        rotateMatrix.setRotate(1, rotate)
        rotateMatrix.setRotate(2, rotate)

        //调整色彩饱和度
        val saturationMatrix = ColorMatrix()
        saturationMatrix.setSaturation(saturation)

        //调整灰度
        val scaleMatrix = ColorMatrix()
        scaleMatrix.setScale(scale, scale, scale, 1f)

        //叠加效果
        val colorMatrix = ColorMatrix()
        colorMatrix.postConcat(rotateMatrix)
        colorMatrix.postConcat(saturationMatrix)
        colorMatrix.postConcat(scaleMatrix)

        //创建一个大小相同的空白Bitmap
        val dstBitmap =
            Bitmap.createBitmap(srcBitmap.width, srcBitmap.height, Bitmap.Config.ARGB_8888)
        //载入Canvas,Paint
        val canvas = Canvas(dstBitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        //绘图
        canvas.drawBitmap(srcBitmap, 0f, 0f, paint)
        return dstBitmap
    }


    // 怀旧
    val colormatrix_huaijiu = floatArrayOf(
        0.2f, 0.5f, 0.1f, 0f,
        40.8f, 0.2f, 0.5f, 0.1f, 0f, 40.8f, 0.2f, 0.5f, 0.1f, 0f, 40.8f, 0f,
        0f, 0f, 1f, 0f
    )

    // 哥特
    val colormatrix_gete = floatArrayOf(
        1.9f, -0.3f, -0.2f, 0f,
        -87.0f, -0.2f, 1.7f, -0.1f, 0f, -87.0f, -0.1f, -0.6f, 2.0f, 0f,
        -87.0f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 淡雅
    val colormatrix_danya = floatArrayOf(
        0.6f, 0.3f, 0.1f, 0f,
        73.3f, 0.2f, 0.7f, 0.1f, 0f, 73.3f, 0.2f, 0.3f, 0.4f, 0f, 73.3f, 0f,
        0f, 0f, 1.0f, 0f
    )

    // 蓝调
    val colormatrix_landiao = floatArrayOf(
        2.1f, -1.4f, 0.6f,
        0.0f, -71.0f, -0.3f, 2.0f, -0.3f, 0.0f, -71.0f, -1.1f, -0.2f, 2.6f,
        0.0f, -71.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )

    // 光晕
    val colormatrix_guangyun = floatArrayOf(
        0.9f, 0f, 0f, 0f, 64.9f,
        0f, 0.9f, 0f, 0f, 64.9f, 0f, 0f, 0.9f, 0f, 64.9f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 梦幻
    val colormatrix_menghuan = floatArrayOf(
        0.8f, 0.3f, 0.1f,
        0.0f, 46.5f, 0.1f, 0.9f, 0.0f, 0.0f, 46.5f, 0.1f, 0.3f, 0.7f, 0.0f,
        46.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )

    // 酒红
    val colormatrix_jiuhong = floatArrayOf(
        1.2f, 0.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f,
        0f, 0f, 0f, 1.0f, 0f
    )

    // 胶片
    val colormatrix_fanse = floatArrayOf(
        -1.0f, 0.0f, 0.0f, 0.0f,
        255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f,
        255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )

    // 湖光掠影
    val colormatrix_huguang = floatArrayOf(
        0.8f, 0.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f,
        0f, 0f, 0f, 1.0f, 0f
    )

    // 褐片
    val colormatrix_hepian = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f,
        0f, 0f, 0f, 1.0f, 0f
    )

}