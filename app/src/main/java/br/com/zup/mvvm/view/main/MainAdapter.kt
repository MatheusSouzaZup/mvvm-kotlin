package br.com.zup.mvvm.view.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.ItemExampleBinding
import br.com.zup.mvvm.room.example.Example

class MainAdapter(var mList: List<Example>, val callback: HeartCallback) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MainViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_example, viewGroup, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, pos: Int) {
        holder.onBind(mList[pos], callback)
    }

    class MainViewHolder(itemView: View, val bind: ItemExampleBinding = DataBindingUtil.bind(itemView)!!) :
        RecyclerView.ViewHolder(itemView) {
        fun onBind(example: Example, callback: HeartCallback) {
            bind.tvItem.text = example.exampleTitle
            bind.btSave.setOnClickListener {
                callback.onClickHeart(example)
                Toast.makeText(itemView.context, "Clicou", Toast.LENGTH_LONG).show()
            }
        }
    }

    interface HeartCallback {
        fun onClickHeart(example: Example)
    }
}