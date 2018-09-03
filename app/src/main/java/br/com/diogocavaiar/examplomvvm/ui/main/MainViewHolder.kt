package br.com.diogocavaiar.examplomvvm.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.diogocavaiar.examplomvvm.databinding.ListUserItemBinding

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ListUserItemBinding? = DataBindingUtil.bind(view)

}

