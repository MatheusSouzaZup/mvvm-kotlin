package br.com.zup.mvvm.view.main

import android.arch.lifecycle.Observer
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.ActivitySavedBinding
import br.com.zup.mvvm.room.example.Example
import br.com.zup.mvvm.view.BaseActivity
import br.com.zup.mvvm.viewmodel.SavedViewModel

class SavedActivity : BaseActivity<ActivitySavedBinding, SavedViewModel>(), MainAdapter.HeartCallback {

    override fun getLayoutId(): Int = R.layout.activity_saved

    override fun getViewModelClass(): Class<SavedViewModel> = SavedViewModel::class.java


    override fun init() {
        setupToolbar()
        viewModel.getSavedExamples().observe(this, Observer {
            if (it != null) {
                populateContainer(it)
            } else {
                //todo error flow
            }
        })
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home ->
                onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun populateContainer(list: MutableList<Example>) {
        val llm = LinearLayoutManager(applicationContext)
        llm.orientation = LinearLayoutManager.VERTICAL
        bind.recyclerView.layoutManager = llm
        bind.recyclerView.adapter = MainAdapter(list, this)
    }

    override fun onClickHeart(example: Example) {
        viewModel.deleteExample(example)
    }

}