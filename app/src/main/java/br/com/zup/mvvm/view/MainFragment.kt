package br.com.zup.mvvm.view

import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.MainFragmentBinding
import br.com.zup.mvvm.viewmodel.MainViewModel
import br.com.zup.zupapp.view.BaseFragment

class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {
    override val fragmentLayout = R.layout.main_fragment;

    override val viewModelClass = MainViewModel::class.java

    override fun init() {
    }
}