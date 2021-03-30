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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawMultiLineShooter(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val gap : Float = w / (2 * lines + 1)
    var x : Float = gap
    save()
    translate(0f, h)
    for (j in 0..(lines - 1)) {
        var sfj1 : Float = 0f
        if (j != 0) {
            sfj1 = sf.divideScale(1+j, parts)
        }
        val sfj2 : Float = sf.divideScale(2 + j, parts)
        x += 2 * gap * sfj1
        save()
        translate(x, -(h - size) * sfj2)
        drawLine(0f, 0f, 0f, -size * sf1, paint)
        restore()
    }
    restore()
}

fun Canvas.drawMLSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawMultiLineShooter(scale, w, h, paint)
}

class MultiLineShooterView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
