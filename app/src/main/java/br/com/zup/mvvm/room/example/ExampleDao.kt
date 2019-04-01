package br.com.zup.mvvm.room.example

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface ExampleDao {
    @Query("SELECT * FROM example")
    abstract fun getAll(): LiveData<List<Example>>

}