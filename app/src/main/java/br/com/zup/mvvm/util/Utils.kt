package br.com.zup.zupapp.util

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.ConnectivityManager
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.view.inputmethod.InputMethodManager
import java.io.IOException
import java.nio.charset.Charset
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by rafaelneiva on 03/11/17.z
 */

object Utils {

    @JvmStatic
    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo.isConnected
    }

    /**
     * @param ctx      Context
     * @param jsonFile The file on assets
     * @return
     */
    fun loadJSONFromAsset(ctx: Context, jsonFile: String): String? {
        val json: String
        try {
            val `is` = ctx.assets.open(jsonFile)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun alreadyInList(list: List<*>, o: Any): Boolean {
        for (`object` in list) {
            if (o == `object`) return true
        }

        return false
    }

    fun shareByPackage(ctx: Context, message: String, pack: String?) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.type = "text/plain"
        if (pack != null)
            sendIntent.setPackage(pack)

        try {
            ctx.startActivity(sendIntent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }

    }

    fun getNavHeight(ctx: Context): Int {
        val resources = ctx.resources
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            resources.getDimensionPixelSize(resourceId)
        } else 0
    }

    fun screenShot(view: View): Bitmap? {
        try {
            val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            view.draw(canvas)
            return bitmap
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    @JvmStatic
    fun expandView(v: View) {
        expandView(v, null)
    }

    @JvmStatic
    fun expandView(v: View, animationListener: Animation.AnimationListener?) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val targetHeight = v.measuredHeight

        v.layoutParams.height = 0
        v.visibility = View.VISIBLE
        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                v.layoutParams.height = if (interpolatedTime == 1f)
                    ViewGroup.LayoutParams.WRAP_CONTENT
                else
                    (targetHeight * interpolatedTime).toInt()
                v.requestLayout()
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        // 1dp/ms + 100
        a.duration = ((targetHeight / v.context.resources.displayMetrics.density).toInt() + 100).toLong()
        if (animationListener != null) {
            a.setAnimationListener(animationListener)
        }
        v.startAnimation(a)
    }

    @JvmStatic
    fun collapseView(v: View) {
        collapseView(v, null)
    }

    @JvmStatic
    fun collapseView(v: View, animationListener: Animation.AnimationListener?) {
        val initialHeight = v.measuredHeight

        val a = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                if (interpolatedTime == 1f) {
                    v.visibility = View.GONE
                } else {
                    v.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                    v.requestLayout()
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        // 1dp/ms + 100
        a.duration = ((initialHeight / v.context.resources.displayMetrics.density).toInt() + 100).toLong()
        if (animationListener != null) {
            a.setAnimationListener(animationListener)
        }
        v.startAnimation(a)
    }

    @JvmStatic
    fun parseDate(time: String?): String? {
        if (time != null) {
            val inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            val outputPattern = "dd 'de' MMMM"
            val inputFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
            val outputFormat = SimpleDateFormat(outputPattern, Locale.getDefault())

            var date: Date? = null
            var str: String? = null

            try {
                date = inputFormat.parse(time)
                str = outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return str
        }

        return time
    }

    @JvmStatic
    fun lastModificationFunction(lastModification: String?): String?{
        if(lastModification != null){
            var dateString = parseDate(lastModification)
            dateString = "Modificado em: $dateString"
            return dateString
        }
        return lastModification
    }

    fun pxFromDp(context: Context, dp: Int): Float {
        return dp * context.resources.displayMetrics.density
    }

}
