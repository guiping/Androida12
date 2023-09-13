package com.peluac.vataret.ucatale.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.peluac.vataret.ucatale.R
import com.peluac.vataret.ucatale.ui.view.SShapeLinearLayout
import com.peluac.vataret.ucatale.ui.view.SShapeRelativeLayout

import kotlin.math.max

/**
 * 描边渐变色的布局管理类，viewGroup专用
 * */
class SShapeManager @JvmOverloads constructor(mView: View, mContext: Context, mAttrs: AttributeSet) {
    var model: SShapeModel = SShapeModel()
    var view: View = mView
    var context: Context = mContext
    var attrs: AttributeSet = mAttrs

    //以下外边框设置
    private var strokeColors: IntArray = intArrayOf(Color.WHITE, Color.BLACK)
    private var strokeColorPositions: FloatArray = floatArrayOf(0F, 1F)
    private val strokePaint = Paint()
    private val strokePath = Path()
    private lateinit var strokeLinearGradient: LinearGradient

    //以下内部填充设置
    private var solidColors: IntArray = intArrayOf(Color.WHITE, Color.BLACK)
    private var solidColorPositions: FloatArray = floatArrayOf(0F, 1F)
    private val solidPaint = Paint()
    private val solidPath = Path()
    private lateinit var solidLinearGradient: LinearGradient

    init {
        getAttrs(attrs)
    }

    fun getAttrs(attrs: AttributeSet) {
        initModel(attrs)
        refreshColors()
        initPaint()
        //此方法、设置背景、设置前景、设置焦点高亮.任何一个即可让viewGroup 执行onDraw
        view.setWillNotDraw(false)
    }

    private fun initModel(attrs: AttributeSet) {
        var typedArray: android.content.res.TypedArray? = null
        when (view) {
            is SShapeLinearLayout -> {
                typedArray = context.obtainStyledAttributes(attrs, R.styleable.SShapeLinearLayout)
                model.topRightRadius = typedArray.getDimension(R.styleable.SShapeLinearLayout_s_top_right_radius, 0.0F)
                model.topLeftRadius = typedArray.getDimension(R.styleable.SShapeLinearLayout_s_top_left_radius, 0.0F)
                model.bottomRightRadius = typedArray.getDimension(R.styleable.SShapeLinearLayout_s_bottom_right_radius, 0.0F)
                model.bottomLeftRadius = typedArray.getDimension(R.styleable.SShapeLinearLayout_s_bottom_left_radius, 0.0F)
                model.cornerRadius = typedArray.getDimension(R.styleable.SShapeLinearLayout_s_corner_radius, 0.0F)
                model.strokeWidth = typedArray.getDimension(R.styleable.SShapeLinearLayout_s_stroke_width, 0.0F)
                model.strokeColorStart = typedArray.getColor(R.styleable.SShapeLinearLayout_s_stroke_gradient_start_color, 0)
                model.strokeColorCenter = typedArray.getColor(R.styleable.SShapeLinearLayout_s_stroke_gradient_center_color, 0)
                model.strokeColorEnd = typedArray.getColor(R.styleable.SShapeLinearLayout_s_stroke_gradient_end_color, 0)
                model.strokeGradientAngle = typedArray.getInt(R.styleable.SShapeLinearLayout_s_stroke_gradient_angle, 0)
                model.solidColorStart = typedArray.getColor(R.styleable.SShapeLinearLayout_s_solid_gradient_start_color, 0)
                model.solidColorCenter = typedArray.getColor(R.styleable.SShapeLinearLayout_s_solid_gradient_center_color, 0)
                model.solidColorEnd = typedArray.getColor(R.styleable.SShapeLinearLayout_s_solid_gradient_end_color, 0)
                model.solidGradientAngle = typedArray.getInt(R.styleable.SShapeLinearLayout_s_solid_gradient_angle, 0)
            }
            is SShapeFrameLayout -> {
                typedArray = context.obtainStyledAttributes(attrs, R.styleable.SShapeFrameLayout)
                model.topRightRadius = typedArray.getDimension(R.styleable.SShapeFrameLayout_s_top_right_radius, 0.0F)
                model.topLeftRadius = typedArray.getDimension(R.styleable.SShapeFrameLayout_s_top_left_radius, 0.0F)
                model.bottomRightRadius = typedArray.getDimension(R.styleable.SShapeFrameLayout_s_bottom_right_radius, 0.0F)
                model.bottomLeftRadius = typedArray.getDimension(R.styleable.SShapeFrameLayout_s_bottom_left_radius, 0.0F)
                model.cornerRadius = typedArray.getDimension(R.styleable.SShapeFrameLayout_s_corner_radius, 0.0F)
                model.strokeWidth = typedArray.getDimension(R.styleable.SShapeFrameLayout_s_stroke_width, 0.0F)
                model.strokeColorStart = typedArray.getColor(R.styleable.SShapeFrameLayout_s_stroke_gradient_start_color, 0)
                model.strokeColorCenter = typedArray.getColor(R.styleable.SShapeFrameLayout_s_stroke_gradient_center_color, 0)
                model.strokeColorEnd = typedArray.getColor(R.styleable.SShapeFrameLayout_s_stroke_gradient_end_color, 0)
                model.strokeGradientAngle = typedArray.getInt(R.styleable.SShapeFrameLayout_s_stroke_gradient_angle, 0)
                model.solidColorStart = typedArray.getColor(R.styleable.SShapeFrameLayout_s_solid_gradient_start_color, 0)
                model.solidColorCenter = typedArray.getColor(R.styleable.SShapeFrameLayout_s_solid_gradient_center_color, 0)
                model.solidColorEnd = typedArray.getColor(R.styleable.SShapeFrameLayout_s_solid_gradient_end_color, 0)
                model.solidGradientAngle = typedArray.getInt(R.styleable.SShapeFrameLayout_s_solid_gradient_angle, 0)
            }
            is SShapeRelativeLayout -> {
                typedArray = context.obtainStyledAttributes(attrs, R.styleable.SShapeRelativeLayout)
                model.topRightRadius = typedArray.getDimension(R.styleable.SShapeRelativeLayout_s_top_right_radius, 0.0F)
                model.topLeftRadius = typedArray.getDimension(R.styleable.SShapeRelativeLayout_s_top_left_radius, 0.0F)
                model.bottomRightRadius = typedArray.getDimension(R.styleable.SShapeRelativeLayout_s_bottom_right_radius, 0.0F)
                model.bottomLeftRadius = typedArray.getDimension(R.styleable.SShapeRelativeLayout_s_bottom_left_radius, 0.0F)
                model.cornerRadius = typedArray.getDimension(R.styleable.SShapeRelativeLayout_s_corner_radius, 0.0F)
                model.strokeWidth = typedArray.getDimension(R.styleable.SShapeRelativeLayout_s_stroke_width, 0.0F)
                model.strokeColorStart = typedArray.getColor(R.styleable.SShapeRelativeLayout_s_stroke_gradient_start_color, 0)
                model.strokeColorCenter = typedArray.getColor(R.styleable.SShapeRelativeLayout_s_stroke_gradient_center_color, 0)
                model.strokeColorEnd = typedArray.getColor(R.styleable.SShapeRelativeLayout_s_stroke_gradient_end_color, 0)
                model.strokeGradientAngle = typedArray.getInt(R.styleable.SShapeRelativeLayout_s_stroke_gradient_angle, 0)
                model.solidColorStart = typedArray.getColor(R.styleable.SShapeRelativeLayout_s_solid_gradient_start_color, 0)
                model.solidColorCenter = typedArray.getColor(R.styleable.SShapeRelativeLayout_s_solid_gradient_center_color, 0)
                model.solidColorEnd = typedArray.getColor(R.styleable.SShapeRelativeLayout_s_solid_gradient_end_color, 0)
                model.solidGradientAngle = typedArray.getInt(R.styleable.SShapeRelativeLayout_s_solid_gradient_angle, 0)
            }

        }
        typedArray?.recycle()
    }

    private fun initPaint() {
        strokePaint.isAntiAlias = true
        strokePaint.style = Paint.Style.STROKE
        strokePaint.strokeWidth = model.strokeWidth
        strokePaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        solidPaint.isAntiAlias = true
        solidPaint.style = Paint.Style.FILL
    }

    fun onDraw(canvas: Canvas?) {
        refreshColors()
        //设置路径关键点
        val pointStart = model.strokeWidth / 2
        val pointTop = model.strokeWidth / 2
        val pointEnd = view.width.toFloat() - model.strokeWidth / 2
        val pointBottom = view.height.toFloat() - model.strokeWidth / 2

        val topLeftRadius: Float = max(model.cornerRadius, model.topLeftRadius)
        val topRightRadius: Float = max(model.cornerRadius, model.topRightRadius)
        val bottomLeftRadius: Float = max(model.cornerRadius, model.bottomLeftRadius)
        val bottomRightRadius: Float = max(model.cornerRadius, model.bottomRightRadius)

        var rectTopRight = RectF((pointEnd - 2 * topRightRadius), pointTop, pointEnd, (pointTop + 2 * topRightRadius))
        var rectBottomRight = RectF((pointEnd - 2 * bottomRightRadius), (pointBottom - 2 * bottomRightRadius), pointEnd, pointBottom)
        var rectBottomLeft = RectF(pointStart, (pointBottom - 2 * bottomLeftRadius), (pointStart + 2 * bottomLeftRadius), pointBottom)
        var rectTopLeft = RectF(pointStart, pointTop, (pointStart + 2 * topLeftRadius), (pointTop + 2 * topLeftRadius))

        //以下绘制内容填充
        refreshSolidGradient()
        solidPath.reset()
        solidPath.moveTo(pointStart + topLeftRadius, pointTop)
        solidPath.lineTo(pointEnd - topRightRadius, pointTop)
        solidPath.arcTo(rectTopRight, 270F, 90F)
        solidPath.lineTo(pointEnd, pointBottom - bottomRightRadius)
        solidPath.arcTo(rectBottomRight, 0F, 90F)
        solidPath.lineTo(pointStart + bottomLeftRadius, pointBottom)
        solidPath.arcTo(rectBottomLeft, 90F, 90F)
        solidPath.lineTo(pointStart, pointTop + topLeftRadius)
        solidPath.arcTo(rectTopLeft, 180F, 90F)
        canvas?.drawPath(solidPath, solidPaint)

        //以下绘制描边
        refreshStrokeGradient()
        strokePath.reset()
        strokePath.moveTo(pointStart + topLeftRadius, pointTop)
        strokePath.lineTo(pointEnd - topRightRadius, pointTop)
        strokePath.arcTo(rectTopRight, 270F, 90F)
        strokePath.lineTo(pointEnd, pointBottom - bottomRightRadius)
        strokePath.arcTo(rectBottomRight, 0F, 90F)
        strokePath.lineTo(pointStart + bottomLeftRadius, pointBottom)
        strokePath.arcTo(rectBottomLeft, 90F, 90F)
        strokePath.lineTo(pointStart, pointTop + topLeftRadius)
        strokePath.arcTo(rectTopLeft, 180F, 90F)
        canvas?.drawPath(strokePath, strokePaint)
    }


    /**
     * 渐变比例，色值
     * */
    private fun refreshColors() {
        if (model.strokeColorCenter == 0) {
            strokeColors = intArrayOf(model.strokeColorStart, model.strokeColorEnd)
            strokeColorPositions = floatArrayOf(0F, 1F)
        } else {
            strokeColors = intArrayOf(model.strokeColorStart, model.strokeColorCenter, model.strokeColorEnd)
            strokeColorPositions = floatArrayOf(0F, 0.5F, 1F)
        }
        if (model.solidColorCenter == 0) {
            solidColors = intArrayOf(model.solidColorStart, model.solidColorEnd)
            solidColorPositions = floatArrayOf(0F, 1F)
        } else {
            solidColors = intArrayOf(model.solidColorStart, model.solidColorCenter, model.solidColorEnd)
            solidColorPositions = floatArrayOf(0F, 0.5F, 1F)
        }
    }

    /**
     * 渐变角度,可能跟随宽高而刷新
     * */
    private fun refreshStrokeGradient() {
        var gradientStart = 0F
        var gradientTop = 0F
        var gradientEnd = 0F
        var gradientBottom = 0F
        when (model.strokeGradientAngle) {
            0, 360 -> gradientEnd = view.width.toFloat()
            45 -> {
                gradientEnd = view.width.toFloat()
                gradientBottom = view.height.toFloat()
            }
            90 -> gradientBottom = view.height.toFloat()
            135 -> {
                gradientStart = view.width.toFloat()
                gradientBottom = view.height.toFloat()
            }
            180 -> gradientStart = view.width.toFloat()
            225 -> {
                gradientStart = view.width.toFloat()
                gradientTop = view.width.toFloat()
            }
            270 -> gradientTop = view.width.toFloat()
            315 -> {
                gradientEnd = view.width.toFloat()
                gradientTop = view.width.toFloat()
            }
        }
        strokeLinearGradient = LinearGradient(gradientStart, gradientTop, gradientEnd, gradientBottom, strokeColors, strokeColorPositions, Shader.TileMode.CLAMP)
        strokePaint.shader = strokeLinearGradient
    }

    /**
     * 渐变角度,可能跟随宽高而刷新
     * */
    private fun refreshSolidGradient() {
        var gradientStart = 0F
        var gradientTop = 0F
        var gradientEnd = 0F
        var gradientBottom = 0F
        when (model.solidGradientAngle) {
            0, 360 -> gradientEnd = view.width.toFloat()
            45 -> {
                gradientEnd = view.width.toFloat()
                gradientBottom = view.height.toFloat()
            }
            90 -> gradientBottom = view.height.toFloat()
            135 -> {
                gradientStart = view.width.toFloat()
                gradientBottom = view.height.toFloat()
            }
            180 -> gradientStart = view.width.toFloat()
            225 -> {
                gradientStart = view.width.toFloat()
                gradientTop = view.width.toFloat()
            }
            270 -> gradientTop = view.width.toFloat()
            315 -> {
                gradientEnd = view.width.toFloat()
                gradientTop = view.width.toFloat()
            }
        }
        solidLinearGradient = LinearGradient(gradientStart, gradientTop, gradientEnd, gradientBottom, solidColors, solidColorPositions, Shader.TileMode.CLAMP)
        solidPaint.shader = solidLinearGradient
    }
}