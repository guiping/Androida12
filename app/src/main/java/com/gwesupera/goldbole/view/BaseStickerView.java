package com.gwesupera.goldbole.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class BaseStickerView extends View {

    public interface OnSizeChangeListener {
        void onSizeChanged(int w, int h, int oldw, int oldh);
    }

    protected static final int N = 0;
    protected static final int D = 1;
    protected static final int Z = 2;

    protected int mode = N;

    protected float ax = 0;
    protected float ay = 0;
    protected float o_Distance = 1f;
    protected float oldRotation = 0;

    protected PointF pint = new PointF();

    protected Matrix m_Matrix = new Matrix();
    protected Matrix d_Matrix = new Matrix();
    protected Matrix matrix_b = new Matrix();
    protected Matrix matrix_s = new Matrix();

    protected RectF rectF;

    protected boolean isOne = true;

    protected OnSizeChangeListener l = null;

    protected IGVBean mCropImageGroup = new IGVBean();

    protected Paint mPaintForBitmap;
    protected int flay = 0;

    public BaseStickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        mPaintForBitmap = new Paint();
        mPaintForBitmap.setAntiAlias(true);
        mPaintForBitmap.setFilterBitmap(true);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            rectF = new RectF(left, top, right, bottom);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCropImageGroup.image_Bitmap != null  ) {
            canvas.drawBitmap(mCropImageGroup.image_Bitmap, mCropImageGroup.mMatrix, mPaintForBitmap);
        }
    }

    public float getD(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public PointF midP(MotionEvent event) {
        PointF point = new PointF();
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);

        return point;
    }

    public float getR(MotionEvent event) {
        double x = event.getX(0) - event.getX(1);
        double y = event.getY(0) - event.getY(1);
        double radians = Math.atan2(y, x);
        return (float) Math.toDegrees(radians);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && isOne) {
            isOne = false;
            setBB();
        }
    }

    protected void onSizeChanged(int w, int h, int old_w, int old_h) {
        super.onSizeChanged(w, h, old_w, old_h);
        if (l != null) {
            l.onSizeChanged(w, h, old_w, old_h);
        }
        setBB();
    }

    public void setBB() {
        if (mCropImageGroup.image_Bitmap != null  ) {
            setBB(mCropImageGroup.image_Bitmap, -1);
        }
    }

    protected float[] get_b_p(Bitmap bitmap, Matrix matrix) {
        float[] dst = new float[8];
        float[] src = new float[]{
                0, 0,
                bitmap.getWidth(), 0,
                0, bitmap.getHeight(),
                bitmap.getWidth(), bitmap.getHeight()
        };

        matrix.mapPoints(dst, src);
        return dst;
    }

    public void setBB(Bitmap bitmap, int flay) {

            this.flay = flay;
            mCropImageGroup.image_Bitmap = bitmap;
            if (mCropImageGroup.mMatrix == null) {
                mCropImageGroup.mMatrix = new Matrix();
            }
            mCropImageGroup.mMatrix.reset();

            if (matrix_b != null && matrix_s != null) {
                matrix_b.reset();
                matrix_s.reset();
            }

            float scale;
            float transY = (getHeight() - mCropImageGroup.image_Bitmap.getHeight()) / 2;
            float transX = (getWidth() - mCropImageGroup.image_Bitmap.getWidth()) / 2;

            matrix_b.postTranslate(transX, transY);
            if (mCropImageGroup.image_Bitmap.getHeight() <= mCropImageGroup.image_Bitmap.getWidth()) {
                scale = (float) getHeight() / mCropImageGroup.image_Bitmap.getHeight();
            } else {
                scale = (float) getWidth() / mCropImageGroup.image_Bitmap.getWidth();
            }
            matrix_b.postScale(scale, scale, getWidth() / 2, getHeight() / 2);

            matrix_s.postTranslate(transX, transY);
            if (mCropImageGroup.image_Bitmap.getHeight() >= mCropImageGroup.image_Bitmap.getWidth()) {
                scale = (float) getWidth() / mCropImageGroup.image_Bitmap.getHeight();
            } else {
                scale = (float) getWidth() / mCropImageGroup.image_Bitmap.getWidth();
            }
            matrix_s.postScale(scale, scale, getWidth() / 2, getHeight() / 2);

            mCropImageGroup.mMatrix.set(matrix_b);

            invalidate();

    }

    protected float[] get_b_p(IGVBean imageGroup) {
        return get_b_p(imageGroup.image_Bitmap, imageGroup.mMatrix);
    }

}
