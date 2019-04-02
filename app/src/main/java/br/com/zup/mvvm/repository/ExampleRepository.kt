package br.com.zup.mvvm.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import br.com.zup.mvvm.model.BaseData
import br.com.zup.mvvm.service.APIClient
import br.com.zup.mvvm.service.AppAPI
import javax.inject.Inject

class ExampleRepository @Inject constructor(val apiClient: AppAPI) : BaseRepository() {

    fun getExample(): LiveData<BaseData<MutableList<String>>> {
        val data = MutableLiveData<BaseData<MutableList<String>>>()

        Handler().postDelayed({
            data.value = mockExample()
        }, 2000)

        return data
    }

    private fun mockExample(): BaseData<MutableList<String>>? {
        val mock = BaseData<MutableList<String>>()

        val list: ArrayList<String> = ArrayList()
        list.add("Oi")
        list.add("Oi")
        list.add("Oi")
        list.add("Oi")
        list.add("Oi")
        mock.result = list

        return mock
    }
}