package br.com.zup.mvvm.model

import android.arch.lifecycle.LiveData


data class BaseData<T>(
    var result: T? = null,
    val message: String? = null,
    val status: String? = null,
    var isInitialLoading: LiveData<Boolean>? = null,
    var isInitialError: LiveData<Boolean>? = null,
    var isAfterLoading: LiveData<Boolean>? = null,
    var isAfterError: LiveData<Boolean>? = null
)