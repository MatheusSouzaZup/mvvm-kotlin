package br.com.zup.mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import br.com.zup.mvvm.repository.ExampleRepository
import br.com.zup.mvvm.room.example.Example
import javax.inject.Inject

class MainViewModel @Inject constructor(private var repository: ExampleRepository) :
    BaseViewModel<MainViewModel.MainViewModelNavigator>() {

    fun getExample(): LiveData<MutableList<Example>?>? {
        return Transformations.map(repository.getExample()) { input ->
            input.data
        }
    }


    fun insertExample(example: Example) {
        repository.inserExample(example.exampleTitle)
    }

    interface MainViewModelNavigator {

    }
}