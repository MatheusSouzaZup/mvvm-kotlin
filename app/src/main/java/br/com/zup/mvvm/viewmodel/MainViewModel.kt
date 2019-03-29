package br.com.zup.mvvm.viewmodel

import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel<MainViewModel.MainViewModelNavigator>() {


    interface MainViewModelNavigator {

    }
}