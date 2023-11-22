package com.gwesupera.goldbole.view;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;


import com.gwesupera.goldbole.R;

import java.util.ArrayList;
import java.util.List;

public class StickerView extends BaseStickerView implements View.OnTouchListener {
    private final Paint mPaintForLineAndCircle;
    private final Path mPath;
    private int moveTag = 0;
    private int deleteTag = 0;
    private int saveTag = 0;
    private final Bitmap deleteIconBitmap;
    private final Bitmap zoomIconBitmap;
    private long mLabelId = -1;

    public long getLabelId() {
        return mLabelId;
    }

    public void setLabelId(long mLabelId) {
        this.mLabelId = mLabelId;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
//        int screenWidth = Measure.px2dip(getContext(),dm.widthPixels);
        setMeasuredDimension(DipToPx.dip2px(getContext(), 312), DipToPx.dip2px(getContext(), 312));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            canvas.drawPath(mPath, mPaintForLineAndCircle);
            for (int i = 0; i < mDecalImageGroupList.size(); i++) {
                IGVBean imageGroup = mDecalImageGroupList.get(i);
                if (saveTag <= 0 && imageGroup.getId() == mLabelId) {
                    float[] points = get_b_p(imageGroup);
                    float x1 = points[0];
                    float y1 = points[1];
                    float x2 = points[2];
                    float y2 = points[3];
                    float x3 = points[4];
                    float y3 = points[5];
                    float x4 = points[6];
                    float y4 = points[7];
                    canvas.drawLine(x1, y1, x2, y2, mPaintForLineAndCircle);
                    canvas.drawLine(x2, y2, x4, y4, mPaintForLineAndCircle);
                    canvas.drawLine(x4, y4, x3, y3, mPaintForLineAndCircle);
                    canvas.drawLine(x3, y3, x1, y1, mPaintForLineAndCircle);
                    canvas.drawCircle(x1, y1, 15, mPaintForLineAndCircle);
                    canvas.drawBitmap(deleteIconBitmap, x1 - deleteIconBitmap.getWidth() / 2, y1 - deleteIconBitmap.getHeight() / 2, mPaintForBitmap);
                    canvas.drawCircle(x4, y4, 15, mPaintForLineAndCircle);
                    canvas.drawBitmap(zoomIconBitmap, x4 - zoomIconBitmap.getWidth() / 2, y4 - zoomIconBitmap.getHeight() / 2, mPaintForBitmap);
                }

                    canvas.drawBitmap(imageGroup.image_Bitmap, imageGroup.mMatrix, mPaintForBitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean pointCheck(IGVBean imageGroup, float x, float y) {
        float[] points = get_b_p(imageGroup);
        float x1 = points[0];
        float y1 = points[1];
        float x2 = points[2];
        float y2 = points[3];
        float x3 = points[4];
        float y3 = points[5];
        float x4 = points[6];
        float y4 = points[7];

        float edge = (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if ((2 + Math.sqrt(2)) * edge >= Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2))
                + Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2))
                + Math.sqrt(Math.pow(x - x3, 2) + Math.pow(y - y3, 2))
                + Math.sqrt(Math.pow(x - x4, 2) + Math.pow(y - y4, 2))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                ax = event.getX();
                ay = event.getY();
                saveTag = 0;
                moveTag = decalCheck(ax, ay);
                deleteTag = deleteCheck(ax, ay);
                saveTag = saveCheck(ax, ay);

                if (moveTag != -1 && deleteTag == -1) {
                    d_Matrix.set(mDecalImageGroupList.get(moveTag).mMatrix);
                    mode = D;
                }
                if (moveTag > -1 && mDecalImageGroupList.size() >= moveTag)
                    setLabelId(mDecalImageGroupList.get(moveTag).getId());
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                moveTag = decalCheck(event.getX(0), event.getY(0));
                int transformTag = decalCheck(event.getX(1), event.getY(1));
                if (moveTag != -1 && transformTag == moveTag && deleteTag == -1) {
                    d_Matrix.set(mDecalImageGroupList.get(moveTag).mMatrix);
                    mode = Z;
                }
                o_Distance = getD(event);
                oldRotation = getR(event);
                if (moveTag > -1 && mDecalImageGroupList.size() >= moveTag)
                    setLabelId(mDecalImageGroupList.get(moveTag).getId());
                pint = midP(event);
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode == Z) {
                    m_Matrix.set(d_Matrix);
                    float newRotation = getR(event) - oldRotation;
                    float newDistance = getD(event);
                    float scale = newDistance / o_Distance;
                    m_Matrix.postScale(scale, scale, pint.x, pint.y);// 縮放
                    m_Matrix.postRotate(newRotation, pint.x, pint.y);// 旋轉
                    if (moveTag != -1) {
                        mDecalImageGroupList.get(moveTag).mMatrix.set(m_Matrix);
                    }
                    if (moveTag > -1 && mDecalImageGroupList.size() >= moveTag)
                        setLabelId(mDecalImageGroupList.get(moveTag).getId());
                    invalidate();
                } else if (mode == D) {
                    m_Matrix.set(d_Matrix);
                    m_Matrix.postTranslate(event.getX() - ax, event.getY() - ay);// 平移
                    if (moveTag != -1) {
                        mDecalImageGroupList.get(moveTag).mMatrix.set(m_Matrix);
                    }
                    if (moveTag > -1 && mDecalImageGroupList.size() >= moveTag)
                        setLabelId(mDecalImageGroupList.get(moveTag).getId());
                    invalidate();
                }
                break;

            case MotionEvent.ACTION_UP:
                if (deleteTag != -1) {
                    mDecalImageGroupList.remove(deleteTag).release();
                    invalidate();
                }
//                if (saveTag != -1) {
                invalidate();
//                }
                mode = N;
                break;

            case MotionEvent.ACTION_POINTER_UP:
                mode = N;
                break;
        }
        return true;
    }


    public List<IGVBean> getDecalImageGroupList() {
        return mDecalImageGroupList;
    }

    public void updateDIGLData(IGVBean iGroup, long mLabelId) {
        for (int i = 0; i < mDecalImageGroupList.size(); i++) {
            IGVBean imageGroup = mDecalImageGroupList.get(i);
            if (mLabelId == imageGroup.getId()) {
                imageGroup.image_Bitmap = iGroup.getImage_Bitmap();
                imageGroup.setTextContent(iGroup.getTextContent());
                invalidate();
                return;
            }
        }
    }

    private final List<IGVBean> mDecalImageGroupList = new ArrayList<>();

    public StickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        deleteIconBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.edit_delete);
        zoomIconBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.fangdasuoxiao);
        mPaintForLineAndCircle = new Paint();
        mPaintForLineAndCircle.setAntiAlias(true);
        mPaintForLineAndCircle.setColor(Color.BLACK);
        mPaintForLineAndCircle.setStrokeWidth(6);
        mPaintForLineAndCircle.setAlpha(170);
        mPath = new Path();
        mPath.moveTo(650, 400);
        mPath.lineTo(950, 400);
        PathEffect effects = new DashPathEffect(new float[]{16, 4}, 0);
        mPaintForLineAndCircle.setPathEffect(effects);
    }

    private boolean circleCheck(IGVBean imageGroup, float x, float y) {
        float[] points = get_b_p(imageGroup);
        float x1 = points[0];
        float y1 = points[1];

        int checkDis = (int) Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));

        if (checkDis < 40) {
            return true;
        }
        return false;
    }

    private boolean saveCheck(IGVBean imageGroup, float x, float y) {
        float[] points = get_b_p(imageGroup);
        float x1 = points[2];
        float y1 = points[3];

        int checkDis = (int) Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));

        if (checkDis < 40) {
            return true;
        }
        return false;
    }

    private int saveCheck(float x, float y) {
        for (int i = 0; i < mDecalImageGroupList.size(); i++) {
            if (saveCheck(mDecalImageGroupList.get(i), x, y)) {
                return 1;
            }
        }
        return -1;
    }

    private int deleteCheck(float x, float y) {
        for (int i = 0; i < mDecalImageGroupList.size(); i++) {
            if (circleCheck(mDecalImageGroupList.get(i), x, y)) {
                return i;
            }
        }
        return -1;
    }

    private int decalCheck(float x, float y) {
        for (int i = 0; i < mDecalImageGroupList.size(); i++) {
            if (pointCheck(mDecalImageGroupList.get(i), x, y)) {
                return i;
            }
        }
        return -1;
    }

    public int getTextStickersSize() {
        int size = 0;
        for (IGVBean imageGroup : mDecalImageGroupList) {
            if (!imageGroup.isStickerOrText) {
                ++size;
            }
        }
        return size;
    }

    public void clearSticker() {
        if (mDecalImageGroupList != null && mDecalImageGroupList.size() > 0) //Limit the number of textures to 20
            mDecalImageGroupList.clear();
        invalidate();
    }

    public void addDecal(Bitmap bitmap, boolean isSticker, String text, int color, Typeface typeface) {
        if (mDecalImageGroupList.size() > 6) //Limit the number of textures to 20
            mDecalImageGroupList.clear();

            IGVBean imageGroupTemp = new IGVBean();
            imageGroupTemp.setStickerOrText(isSticker);
            imageGroupTemp.setTextContent(text);
            imageGroupTemp.setColorRes(color);
            imageGroupTemp.setTypeface(typeface);

            imageGroupTemp.setImage_Bitmap(bitmap);
            if (imageGroupTemp.mMatrix == null) {
                imageGroupTemp.mMatrix = new Matrix();
            }
            float transX = (getWidth() - imageGroupTemp.image_Bitmap.getWidth()) / 2;
            float transY = (getHeight() - imageGroupTemp.image_Bitmap.getHeight()) / 2;
            imageGroupTemp.mMatrix.postTranslate(transX, transY);
            imageGroupTemp.mMatrix.postScale(1f, 1f, getWidth() / 2, getHeight() / 2);
            imageGroupTemp.setId(System.currentTimeMillis());
            setLabelId(imageGroupTemp.getId());
            if (color >= 0)
                mDecalImageGroupList.add(imageGroupTemp);
            invalidate();
    }

    public Bitmap getMaskBitmap() {
        if (rectF == null || mDecalImageGroupList.size() == 0)
            return null;
        Bitmap bitmap = Bitmap.createBitmap(this.getWidth() + (int) rectF.left, this.getHeight() + (int) rectF.top,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);

        if (mCropImageGroup.getImage_Bitmap() != null  && mCropImageGroup.mMatrix != null) {
            canvas.drawBitmap(mCropImageGroup.getImage_Bitmap(), mCropImageGroup.mMatrix, mPaintForBitmap);
        }

        for (IGVBean imageGroup : mDecalImageGroupList) {
             canvas.drawBitmap(imageGroup.getImage_Bitmap(), imageGroup.mMatrix, mPaintForBitmap);
        }

        canvas.save();
        canvas.restore();
        try {
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}
