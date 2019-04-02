package br.com.zup.mvvm.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import br.com.zup.mvvm.model.BaseData
import br.com.zup.mvvm.room.example.Example
import br.com.zup.mvvm.room.example.ExampleDao
import java.util.concurrent.Executors
import javax.inject.Inject

class SavedExampleRepository @Inject constructor(var exampleDao: ExampleDao) : BaseRepository() {


    fun getAllExample(): LiveData<BaseData<MutableList<Example>>> {
        return Transformations.map(exampleDao.getAll()) { input ->
            val data = BaseData(data = input)
            data
        }
    }

    fun deleteExample(example: Example) {
        Executors.newSingleThreadExecutor().execute { exampleDao.deleteExample(example) }
    }

}