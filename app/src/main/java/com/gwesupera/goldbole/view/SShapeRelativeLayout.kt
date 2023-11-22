package com.gwesupera.goldbole.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet

import android.widget.RelativeLayout
import com.gwesupera.goldbole.view.SShapeManager
import com.gwesupera.goldbole.view.SShapeModel


/**
 * 描边渐变色的布局
 * */
class SShapeRelativeLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : RelativeLayout(context, attrs, defStyleAttr) {
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
    }

    fun refreshShapeLayout() {
        invalidate()
    }
}