package br.com.zup.mvvm.view.main

import android.arch.lifecycle.Observer
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.ActivityMainBinding
import br.com.zup.mvvm.view.BaseActivity
import br.com.zup.mvvm.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun init() {

        viewModel.getExample()?.observe(this, Observer {
            if (it != null) {
                populateContainer(it)
            } else {
                // todo error message
            }
        })
    }

    fun populateContainer(list: MutableList<String>) {
        val llm = LinearLayoutManager(applicationContext)
        llm.orientation = VERTICAL
        bind.recyclerView.layoutManager = llm
        bind.recyclerView.adapter = MainAdapter(list)
    }
}
