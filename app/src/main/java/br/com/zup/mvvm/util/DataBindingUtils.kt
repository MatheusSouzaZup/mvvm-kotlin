package br.com.zup.zupapp.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import br.com.zup.multistatelayout.MultiStateLayout
import com.squareup.picasso.Picasso

/**
 * Created by rafaelneiva on 02/10/18.
 */
object DataBindingUtils {

    @JvmStatic
    @BindingAdapter("msl_state")
    fun setState(multiStateLayout: MultiStateLayout, state: MultiStateLayout.State) {
        multiStateLayout.setState(state)
    }

    @JvmStatic
    @BindingAdapter("img_url")
    fun setPicassoImage(imageView: ImageView, imgUrl: String?) {
        if (imgUrl == null) return
        Picasso.get()
            .load(imgUrl)
            .into(imageView)
    }
}
