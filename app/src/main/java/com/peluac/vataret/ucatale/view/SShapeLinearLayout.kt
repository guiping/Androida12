package com.peluac.vataret.ucatale.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.LinearLayout
import com.peluac.vataret.ucatale.view.SShapeManager
import com.peluac.vataret.ucatale.view.SShapeModel

class SShapeLinearLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
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