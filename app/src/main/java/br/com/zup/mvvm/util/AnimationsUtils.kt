package br.com.zup.zupapp.util

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation

object AnimationsUtils {

    fun expand(view: View) {
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val targetHeight = view.measuredHeight

        view.layoutParams.height = 0
        view.visibility = View.VISIBLE
        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                view.layoutParams.height = if (interpolatedTime == 1f)
                    ViewGroup.LayoutParams.WRAP_CONTENT
                else
                    (targetHeight * interpolatedTime).toInt()
                view.requestLayout()
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        a.duration = ((targetHeight / view.context.resources.displayMetrics.density).toInt() + 100).toLong()
        view.startAnimation(a)
    }

    fun collapse(view: View) {
        val initialHeight = view.measuredHeight

        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                if (interpolatedTime == 1f) {
                    view.visibility = View.GONE
                } else {
                    view.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                    view.requestLayout()
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        a.duration = ((initialHeight / view.context.resources.displayMetrics.density).toInt() + 100).toLong()
        view.startAnimation(a)
    }
}