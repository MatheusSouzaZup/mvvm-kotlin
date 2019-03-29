package br.com.zup.mvvm.view

import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.ActivityMainBinding
import br.com.zup.mvvm.viewmodel.MainViewModel
import br.com.zup.zupapp.view.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
