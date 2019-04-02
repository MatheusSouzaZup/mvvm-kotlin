package br.com.zup.mvvm.view.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.mvvm.R
import br.com.zup.mvvm.databinding.ItemExampleBinding

class MainAdapter(var mList: List<String>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MainViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_example, viewGroup, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, pos: Int) {
        holder.onBind(mList[pos])
    }

    class MainViewHolder(itemView: View, val bind: ItemExampleBinding = DataBindingUtil.bind(itemView)!!) :
        RecyclerView.ViewHolder(itemView) {
        fun onBind(title: String) {
            bind.tvItem.text = title
        }
    }
}