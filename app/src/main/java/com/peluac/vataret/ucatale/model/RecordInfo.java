package com.peluac.vataret.ucatale.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * create by ping at 2023/9/12
 */
public class RecordInfo implements Serializable {

    private Bitmap coupleBitmap;
    private String coupleBitmapUri;
    private String time;

    public String getCoupleBitmapUri() {
        return coupleBitmapUri;
    }

    public void setCoupleBitmapUri(String coupleBitmapUri) {
        this.coupleBitmapUri = coupleBitmapUri;
    }


    public Bitmap getCoupleBitmap() {
        return coupleBitmap;
    }

    public void setCoupleBitmap(Bitmap coupleBitmap) {
        this.coupleBitmap = coupleBitmap;
    }


    public RecordInfo() {
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
