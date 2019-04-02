package br.com.zup.mvvm.service

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AppAPI {

    @GET("xD")
    fun getExample(): Call<ResponseBody>

}
