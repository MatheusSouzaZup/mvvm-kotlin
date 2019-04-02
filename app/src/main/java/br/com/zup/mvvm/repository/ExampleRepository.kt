package br.com.zup.mvvm.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import br.com.zup.mvvm.model.BaseData
import br.com.zup.mvvm.room.example.Example
import br.com.zup.mvvm.room.example.ExampleDao
import br.com.zup.mvvm.service.AppAPI
import java.util.concurrent.Executors
import javax.inject.Inject

class ExampleRepository @Inject constructor(val apiClient: AppAPI, var exampleDao: ExampleDao) : BaseRepository() {

    fun getExample(): LiveData<BaseData<MutableList<Example>>> {
        val data = MutableLiveData<BaseData<MutableList<Example>>>()

        Handler().postDelayed({
            data.value = mockExample()
        }, 2000)

        return data
    }

    fun inserExample(name: String) {
        val example = Example(exampleTitle = name)
        Executors.newSingleThreadExecutor().execute { exampleDao.insertExample(example) }
    }

    private fun mockExample(): BaseData<MutableList<Example>>? {
        val mock = BaseData<MutableList<Example>>()

        val list: ArrayList<Example> = ArrayList()
        list.add(Example(exampleTitle = "Gol"))
        list.add(Example(exampleTitle = "Golf"))
        list.add(Example(exampleTitle = "Polo"))
        list.add(Example(exampleTitle = "Onix"))
        list.add(Example(exampleTitle = "Corolla"))
        list.add(Example(exampleTitle = "HB20"))
        mock.data = list

        return mock
    }
}