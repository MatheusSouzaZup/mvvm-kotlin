package br.com.zup.mvvm.view.main

import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.MainFragmentBinding
import br.com.zup.mvvm.view.BaseFragment
import br.com.zup.mvvm.viewmodel.MainViewModel

class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {
    override val fragmentLayout = R.layout.main_fragment

    override val viewModelClass = MainViewModel::class.java

    override fun init() {
    }
}