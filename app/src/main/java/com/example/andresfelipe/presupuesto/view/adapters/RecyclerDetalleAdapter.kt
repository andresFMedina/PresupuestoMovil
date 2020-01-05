package com.example.andresfelipe.presupuesto.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.andresfelipe.presupuesto.BR
import com.example.andresfelipe.presupuesto.model.detalle.Detalle
import com.example.andresfelipe.presupuesto.viewmodel.DetalleViewModel

class RecyclerDetalleAdapter(var detalleViewModel: DetalleViewModel, var resource: Int): RecyclerView.Adapter<RecyclerDetalleAdapter.DetalleHolder>() {

    var detalles: List<Detalle>? = null

    fun setDetallesList(detallesList: List<Detalle>?){
        this.detalles = detallesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return DetalleHolder(binding)
    }

    override fun getItemCount(): Int {
        return detalles?.size ?: 0
    }

    override fun onBindViewHolder(holder: DetalleHolder, position: Int) {
        holder.setDataCard(detalleViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }


    class DetalleHolder(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(detalleViewModel: DetalleViewModel, position: Int){
            binding?.setVariable(BR.model, detalleViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }
    }
}