package com.example.andresfelipe.presupuesto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andresfelipe.presupuesto.R
import com.example.andresfelipe.presupuesto.model.detalle.Detalle
import com.example.andresfelipe.presupuesto.model.detalle.DetalleObservable
import com.example.andresfelipe.presupuesto.view.adapters.RecyclerDetalleAdapter

class DetalleViewModel: ViewModel() {

    private var detalleObservable: DetalleObservable = DetalleObservable()
    private var recyclerDetalleAdapter: RecyclerDetalleAdapter? = null

    fun callDetallesByAnalisisId(anallisisId: Int){
        detalleObservable.callDetallesByAnalisisId(anallisisId)
    }

    fun getDetalles(): MutableLiveData<List<Detalle>>{
        return detalleObservable.getDetalles()
    }

    fun setDetallesInAdapter(detalleList: List<Detalle>) {
        recyclerDetalleAdapter?.setDetallesList(detalleList)
        recyclerDetalleAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerDetalleAdapter(): RecyclerDetalleAdapter?{
        recyclerDetalleAdapter = RecyclerDetalleAdapter(this, R.layout.cardview_detalle)
        return recyclerDetalleAdapter
    }

    fun getDetalleAt(position: Int): Detalle? {
        val detalles: List<Detalle>? = detalleObservable.getDetalles().value
        return detalles?.get(position)
    }
}