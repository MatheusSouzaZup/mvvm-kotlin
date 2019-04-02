package br.com.zup.mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import br.com.zup.mvvm.model.BaseData
import br.com.zup.mvvm.repository.SavedExampleRepository
import br.com.zup.mvvm.room.example.Example
import javax.inject.Inject

class SavedViewModel @Inject constructor(val savedExampleRepository: SavedExampleRepository) :
    BaseViewModel<SavedViewModel.SavedNavigator>() {

    fun getSavedExamples(): LiveData<MutableList<Example>> {
        return Transformations.map(savedExampleRepository.getAllExample()) { input ->
            input.data
        }
    }

    fun deleteExample(example: Example) {
        savedExampleRepository.deleteExample(example)
    }

    interface SavedNavigator {

    }
}