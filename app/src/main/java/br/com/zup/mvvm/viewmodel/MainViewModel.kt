package br.com.zup.mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import br.com.zup.mvvm.model.BaseData
import br.com.zup.mvvm.repository.ExampleRepository
import java.util.ArrayList
import javax.inject.Inject

class MainViewModel @Inject constructor(var repository: ExampleRepository) :
    BaseViewModel<MainViewModel.MainViewModelNavigator>() {

    fun getExample(): LiveData<MutableList<String>?>? {
        return Transformations.map(repository.getExample()) { input ->
            input.result
        }
    }


    interface MainViewModelNavigator {

    }
}