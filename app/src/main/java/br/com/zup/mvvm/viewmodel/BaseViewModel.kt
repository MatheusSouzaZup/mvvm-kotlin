package br.com.zup.mvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean


open class BaseViewModel<N> protected constructor() : ViewModel() {

    var showLoading = ObservableBoolean(false)

    var viewContract: N? = null

}