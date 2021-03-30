package com.example.multilineshooterview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#3F51B5",
    "#BF360C",
    "#006064",
    "#64DD17"
).map {
    Color.parseColor(it)
}.toTypedArray()
val lines : Int = 4
val parts : Int = lines * 2
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
val scGap : Float = 0.02f / parts
val strokeFactor : Float = 90f
val sizeFactor : Float = 8.9f
