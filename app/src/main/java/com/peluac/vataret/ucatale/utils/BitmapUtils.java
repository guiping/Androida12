package com.peluac.vataret.ucatale.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BitmapUtils {
    public static Bitmap cropBitmap(Bitmap bitmap) {//从中间截取一个正方形
        int w = bitmap.getWidth(); // 得到图片的宽，高
        int h = bitmap.getHeight();
        int cropWidth = w >= h ? h : w;// 裁切后所取的正方形区域边长

        return Bitmap.createBitmap(bitmap, (bitmap.getWidth() - cropWidth) / 2,
                (bitmap.getHeight() - cropWidth) / 2, cropWidth, cropWidth);
    }
    public Bitmap adjustSaturation(Bitmap bitmap, float saturationLevel) {
        // 将饱和度转换为合法的取值范围 [-1, 1]
        float saturation = Math.max(0, Math.min(saturationLevel, 1));

        // 创建颜色矩阵并设置饱和度
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(saturation);

        // 创建画笔，并应用颜色矩阵
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(matrix));

        // 根据画笔绘制新的Bitmap
        Bitmap adjustedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(adjustedBitmap);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        return adjustedBitmap;
    }


}
