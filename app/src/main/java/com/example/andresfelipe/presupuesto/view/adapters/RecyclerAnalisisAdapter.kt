package com.example.andresfelipe.presupuesto.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.andresfelipe.presupuesto.BR
import com.example.andresfelipe.presupuesto.model.analisisunitario.AnalisisUnitario
import com.example.andresfelipe.presupuesto.viewmodel.AnalisisUnitarioViewModel

class RecyclerAnalisisAdapter(var analisisUnitarioViewModel: AnalisisUnitarioViewModel, var resource: Int): RecyclerView.Adapter<RecyclerAnalisisAdapter.AnalisisHolder>() {

    var analisis: List<AnalisisUnitario>? = null

    fun setAnalisisList(analisis: List<AnalisisUnitario>?) {
        this.analisis = analisis
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalisisHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return AnalisisHolder(binding)
    }

    override fun getItemCount(): Int {
        return analisis?.size ?: 0
    }

    override fun onBindViewHolder(holder: AnalisisHolder, position: Int) {
        holder.setDataCard(analisisUnitarioViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }


    class AnalisisHolder(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(analisisUnitarioViewModel: AnalisisUnitarioViewModel, position: Int){
            binding?.setVariable(BR.model, analisisUnitarioViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }
    }
}