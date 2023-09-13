package com.peluac.vataret.ucatale.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
public class IGVBean {
    public long id;
    public Bitmap image_Bitmap;
    public Matrix mMatrix = new Matrix();
    public boolean isStickerOrText = true;
    public String textContent;
    public int colorRes;
    public Typeface typeface;

    public int getColorRes() {
        return colorRes;
    }

    public void setColorRes(int colorRes) {
        this.colorRes = colorRes;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public Bitmap getImage_Bitmap() {
        return image_Bitmap;
    }

    public void setImage_Bitmap(Bitmap image_Bitmap) {
        this.image_Bitmap = image_Bitmap;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStickerOrText() {
        return isStickerOrText;
    }

    public void setStickerOrText(boolean stickerOrText) {
        isStickerOrText = stickerOrText;
    }

    public void release() {
        if (image_Bitmap != null) {
            //image_Bitmap.recycle();
            image_Bitmap = null;
        }

        if (mMatrix != null) {
            mMatrix.reset();
            mMatrix = null;
        }
    }
}
