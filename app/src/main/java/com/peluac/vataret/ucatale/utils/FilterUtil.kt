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
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.peluac.vataret.ucatale.model.WoybuZdosDishaClick
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
        var recordInfo = com.peluac.vataret.ucatale.model.WoybuZdosDishaClick()
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

    /**
     * 通过更改图片像素点的RGBA值，生成底片效果
     *
     * @param scrBitmap
     * @return
     */
    fun beautyImage(scrBitmap: Bitmap): Bitmap {
        val width = scrBitmap.width
        val height = scrBitmap.height
        val count = width * height
        val oldPixels = IntArray(count)
        val newPixels = IntArray(count)
        scrBitmap.getPixels(oldPixels, 0, width, 0, 0, width, height)
        for (i in oldPixels.indices) {
            val pixel = oldPixels[i]
            var r = Color.red(pixel)
            var g = Color.green(pixel)
            var b = Color.blue(pixel)
            r = 255 - r
            g = 255 - g
            b = 255 - b
            if (r > 255) {
                r = 255
            }
            if (g > 255) {
                g = 255
            }
            if (b > 255) {
                b = 255
            }
            if (r < 0) {
                r = 0
            }
            if (g < 0) {
                g = 0
            }
            if (b < 0) {
                b = 0
            }
            newPixels[i] = Color.rgb(r, g, b)
        }
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        bitmap.setPixels(newPixels, 0, width, 0, 0, width, height)
        return bitmap
    }

    // 黑白
    val colormatrix_heibai = floatArrayOf(
        1.438f, -0.062f, -0.062f, 0f, 0f,
        -0.122f, 1.378f, -0.122f, 0f, 0f,
        -0.016f, -0.016f, 1.483f, 0f, 0f,
        -0.03f, 0.05f, -0.02f, 1f, 0f
    )

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

    // 复古
    val colormatrix_fugu = floatArrayOf(
        0.9f, 0.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f,
        0f, 0f, 0f, 1.0f, 0f
    )

    // 泛黄
    val colormatrix_huan_huang = floatArrayOf(
        1.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f,
        0.0f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 传统
    val colormatrix_chuan_tong = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 1.0f, 0.0f, 0f, -10f, 0.0f, 0.0f, 1.0f, 0f, -10f, 0f, 0f,
        0f, 1f, 0f
    )

    // 胶片2
    val colormatrix_jiao_pian = floatArrayOf(
        0.71f, 0.2f, 0.0f,
        0.0f, 60.0f, 0.0f, 0.94f, 0.0f, 0.0f, 60.0f, 0.0f, 0.0f, 0.62f,
        0.0f, 60.0f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 锐色
    val colormatrix_ruise = floatArrayOf(
        4.8f, -1.0f, -0.1f, 0f,
        -388.4f, -0.5f, 4.4f, -0.1f, 0f, -388.4f, -0.5f, -1.0f, 5.2f, 0f,
        -388.4f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 清宁
    val colormatrix_qingning = floatArrayOf(
        0.9f, 0f, 0f, 0f, 0f, 0f,
        1.1f, 0f, 0f, 0f, 0f, 0f, 0.9f, 0f, 0f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 浪漫
    val colormatrix_langman = floatArrayOf(
        0.9f, 0f, 0f, 0f, 63.0f,
        0f, 0.9f, 0f, 0f, 63.0f, 0f, 0f, 0.9f, 0f, 63.0f, 0f, 0f, 0f, 1.0f, 0f
    )

    // 夜色
    val colormatrix_yese = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0.0f,
        -66.6f, 0.0f, 1.1f, 0.0f, 0.0f, -66.6f, 0.0f, 0.0f, 1.0f, 0.0f,
        -66.6f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )
    val colormatrix_yese1 = floatArrayOf(
        0.393f, 0.769f, 0.189f, 0f, 0f,
        0.349f, 0.686f, 0.168f, 0f, 0f,
        0.272f, 0.534f, 0.131f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
    val colormatrix_yese2 = floatArrayOf(
        2f, 0f, 0f, 0f, 0f,
        0f, 1f, 0f, 0f, 0f,
        0f, 0f, 1f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
    val colormatrix_yese3 = floatArrayOf(
        1f, 0f, 0f, 0f, 0f,
        0f, 1.4f, 0f, 0f, 0f,
        0f, 0f, 1f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
    val colormatrix_yese4 = floatArrayOf(
        1f, 0f, 0f, 0f, 0f,
        0f, 1f, 0f, 0f, 0f,
        0f, 0f, 1.6f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
    val colormatrix_yese5 = floatArrayOf(
        1f, 0f, 0f, 0f, 50f,
        0f, 1f, 0f, 0f, 50f,
        0f, 0f, 1f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
    val colormatrix_6 = floatArrayOf(
        0.78f, 0f, 0f, 0f, 63.0f,
        0f, 0.9f, 0f, 0f, 63.0f, 0f, 0f, 0.9f, 0f, 63.0f, 0f, 0f, 0f, 1.0f, 0f
    )
    val colormatrix_7 = floatArrayOf(
        0.78f, 0f, 0f, 0f, 53.0f,
        0f, 0.9f, 0f, 0f, 63.0f, 0f, 0f, 0.9f, 0f, 63.0f, 0f, 0f, 0f, 1.0f, 0f
    )
    val colormatrix_8 = floatArrayOf(
        0.78f, 0f, 0f, 0f, 53.0f,
        0f, 0.9f, 0f, 0f, 63.0f, 0f, 0f, 0.3f, 0f, 63.0f, 0f, 0f, 0f, 1.0f, 0f
    )
    val colormatrix_ct = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 1.0f, 0.0f, 0f, -10f, 0.0f, 1.0f, 1.0f, 0.5f, -10f, -1f, 1f,
        0f, 1f, 0f
    )
    val colormatrix_ct2 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -1f, 0.0f, 1.0f, 0.0f, 0f, -10f, 15.0f, 10.5f, 1.0f, 0.5f, -10f, -2f, 2f,
        0f, 1f, 2f
    )
    val colormatrix_ct3 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -5f, 0.0f, 1.0f, 0.0f, 0f, -10f, 3.0f, 20.5f, 1.0f, 0.5f, -10f, -3f, 3f,
        0f, 1f, 3f
    )
    val colormatrix_ct4 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 1.0f, 0.0f, 0f, -10f, 0.0f, 0.0f, 1.0f, 0.5f, -10f, 0f, 0f,
        0f, 1f, 1f
    )
    val colormatrix_ct5 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 1.0f, 0.0f, 0f, -10f, -10.0f, 0.0f, 3.0f, 0.5f, -10f, 0f, 0f,
        0f, 1f, 0f
    )
    val colormatrix_ct6 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 1.0f, 0.0f, 0f, -10f, 8.0f, -10.0f, 19.0f, 0.5f, -10f, 0f, 0f,
        0f, 1f, 0f
    )
    val colormatrix_ct7 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 2.0f, 0.0f, 0f, -10f, 0.0f, 0.0f, 1.0f, 0.5f, -10f, 0f, 0f,
        0f, 1f, 0f
    )
    val colormatrix_ct8 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 1.0f, 1.0f, 0.0f, 0f, -10f, 0.0f, 0.0f, 1.0f, 0.5f, -10f, 0f, 0f,
        0f, 1f, 0f
    )
    val colormatrix_ct9 = floatArrayOf(
        1.0f, 0.0f, 0.0f, 0f,
        -10f, 0.0f, 0.0f, 0.0f, 0f, -10f, 0.0f, 0.0f, 1.0f, 0.5f, -10f, 0f, 0f,
        0f, 1f, 0f
    )

    var array = floatArrayOf(
        1.438.toFloat(), (-0.062).toFloat(), (-0.062).toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.378.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (-0.016).toFloat(), (-0.016).toFloat(), 1.483.toFloat(), 0f, 0f,
        (-0.03).toFloat(), 0.05.toFloat(), (-0.02).toFloat(), 1f, 0f
    )
    var array1 = floatArrayOf(
        0.438.toFloat(), (-0.062).toFloat(), (-0.062).toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.378.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (-0.016).toFloat(), (-0.016).toFloat(), 1.483.toFloat(), 0f, 0f,
        (-0.03).toFloat(), 0.05.toFloat(), (-0.02).toFloat(), 1f, 0f
    )

    var array2 = floatArrayOf(
        0.438.toFloat(), (-0.062).toFloat(), (-0.062).toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.378.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (-0.016).toFloat(), (-0.016).toFloat(), 0.483.toFloat(), 0f, 0f,
        (-0.03).toFloat(), 0.05.toFloat(), (-0.02).toFloat(), 1f, 0f
    )

    var array3 = floatArrayOf(
        1.2.toFloat(), (-0.062).toFloat(), (-0.062).toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.378.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (-0.016).toFloat(), (-0.016).toFloat(), 0.483.toFloat(), 0f, 0f,
        (-0.03).toFloat(), 0.05.toFloat(), (-0.02).toFloat(), 1f, 0f
    )

    var array4 = floatArrayOf(
        1.2.toFloat(), (-0.062).toFloat(), (-0.062).toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.378.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (-0.016).toFloat(), (-0.016).toFloat(), 0.toFloat(), 0f, 0f,
        (-0.03).toFloat(), 0.05.toFloat(), (-0.1).toFloat(), 1f, 0f
    )

    var array5 = floatArrayOf(
        1.2.toFloat(), (-0.062).toFloat(), 0.5.toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (-0.016).toFloat(), (-0.016).toFloat(), 0.toFloat(), 0f, 0f,
        (-0.03).toFloat(), 0.05.toFloat(), (-0.1).toFloat(), 1f, 0f
    )

    var array6 = floatArrayOf(
        1.2.toFloat(), (-0.062).toFloat(), 0.5.toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (0.016).toFloat(), (0.016).toFloat(), 0.toFloat(), 0f, 0f,
        (0.03).toFloat(), 0.05.toFloat(), (-0.1).toFloat(), 1f, 0f
    )

    var array7 = floatArrayOf(
        1.2.toFloat(), (-0.062).toFloat(), 0.5.toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (0.016).toFloat(), (0.016).toFloat(), 0.toFloat(), 0f, 0f,
        (0.03).toFloat(), 0.05.toFloat(), (-0.1).toFloat(), 1f, 0f
    )

    var array8 = floatArrayOf(
        1.2.toFloat(), (-0.062).toFloat(), 0.5.toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (0.016).toFloat(), (0.016).toFloat(), 0.toFloat(), 0f, 0f,
        (0.03).toFloat(), 0.05.toFloat(), (-0.1).toFloat(), 1f, 0f
    )

    var array9 = floatArrayOf(
        1.2.toFloat(), (0.062).toFloat(), 0.5.toFloat(), 0f, 0f,
        (-0.122).toFloat(), 1.toFloat(), (-0.122).toFloat(), 0f, 0f,
        (0.016).toFloat(), (0.016).toFloat(), 0.toFloat(), 0f, 0f,
        (0.03).toFloat(), 0.05.toFloat(), (1).toFloat(), 0.5f, 0f
    )

    fun loadBitmapFromView(v: View?): Bitmap? {
        if (v == null) {
            return null
        }
        val screenshot: Bitmap
        screenshot = Bitmap.createBitmap(v.width, v.height, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(screenshot)
        canvas.translate(-v.scrollX.toFloat(), -v.scrollY.toFloat())
        v.draw(canvas)
        return screenshot
    }
    fun imgToBitMap(v : View?): Bitmap? {
        if (v == null) {
            return null
        }
        if (v.measuredWidth == 0) {
            return null
        }
        if (v.measuredHeight == 0) {
            return null
        }
        val screenshot: Bitmap = Bitmap.createBitmap(v.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(screenshot)
        canvas.translate(-v.scrollX.toFloat(), -v.scrollY.toFloat())
        v.draw(canvas)
        return screenshot
    }
}