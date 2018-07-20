package com.example.sugino.conpass_mvvm

import android.content.Context
import android.databinding.DataBindingUtil
import android.provider.ContactsContract
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sugino.conpass_mvvm.databinding.ActivityMainBinding
import com.example.sugino.conpass_mvvm.databinding.CellMainBinding

class MainRecyclerAdapter (private val context: Context): RecyclerView.Adapter < MainRecyclerAdapter.ViewHolder >() {

    var events: List<ConpassEvent.Event>? = null
    set(value) {
        DiffUtil.calculateDiff(DiffUtilCallback(field,value)).dispatchUpdatesTo(this)
        field = value
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ev = events?.getOrNull(position) ?: return
        holder.binding.event = ev
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<CellMainBinding>(LayoutInflater.from(context), R.layout.cell_main,p0,false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = events?.size ?: 0

    inner class ViewHolder(val binding: CellMainBinding): RecyclerView.ViewHolder(binding.root)
}