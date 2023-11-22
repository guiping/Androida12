package com.gwesupera.goldbole.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout


/**
 * 描边渐变色的布局
 * */
class SShapeFrameLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {
    private var manager: SShapeManager = SShapeManager(this, context, attrs)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        manager.onDraw(canvas)
    }

    fun getShapeModel(): SShapeModel {
        return manager.model
    }
    fun setShapeModel(model: SShapeModel)  {
        manager.model = model
        refreshShapeLayout()
    }

    fun refreshShapeLayout() {
        invalidate()
    }
}