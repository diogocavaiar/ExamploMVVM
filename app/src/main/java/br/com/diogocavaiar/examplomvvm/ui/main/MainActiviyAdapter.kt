package br.com.diogocavaiar.examplomvvm.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.diogocavaiar.examplomvvm.R
import br.com.diogocavaiar.examplomvvm.domain.model.Item
import br.com.diogocavaiar.examplomvvm.ui.base.BaseAdapter

class MainActiviyAdapter constructor(list: List<Item>) : BaseAdapter<Item>(list) {

    override fun onCreateViewHolderBase(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return return MainViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_user_item, parent, false))
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) {
        val binding = (holder as MainViewHolder).binding
        val item = list[position]
        binding?.item = item
    }
}