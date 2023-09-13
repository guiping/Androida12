package com.peluac.vataret.ucatale.view

import java.io.Serializable


data class SShapeModel @JvmOverloads constructor(
    //以下通用设置
    var cornerRadius: Float = 0.0F,
    var topLeftRadius: Float = 0.0F,
    var topRightRadius: Float = 0.0F,
    var bottomLeftRadius: Float = 0.0F,
    var bottomRightRadius: Float = 0.0F,
    //以下外边框设置
    var strokeGradientAngle: Int = 90,
    var strokeWidth: Float = 0.0F,
    var strokeColorStart: Int = 0,
    var strokeColorCenter: Int = 0,
    var strokeColorEnd: Int = 0,
    //以下内部填充设置
    var solidGradientAngle: Int = 90,
    var solidColorStart: Int = 0,
    var solidColorCenter: Int = 0,
    var solidColorEnd: Int = 0,
) : Serializable
