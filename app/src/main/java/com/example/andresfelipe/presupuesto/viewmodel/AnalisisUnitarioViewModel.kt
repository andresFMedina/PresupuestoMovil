package com.example.andresfelipe.presupuesto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andresfelipe.presupuesto.R
import com.example.andresfelipe.presupuesto.model.analisisunitario.AnalisisUnitario
import com.example.andresfelipe.presupuesto.model.analisisunitario.AnalisisUnitarioObservable
import com.example.andresfelipe.presupuesto.view.adapters.RecyclerAnalisisAdapter

class AnalisisUnitarioViewModel: ViewModel() {

    private var analisisUnitarioObservable: AnalisisUnitarioObservable = AnalisisUnitarioObservable()
    private var recyclerAnalisisAdapter: RecyclerAnalisisAdapter? = null
    //var selected:

    fun callPresupuesto(){
        analisisUnitarioObservable.callPresupuesto()
    }

    fun getAnalisisUnitarios(): MutableLiveData<List<AnalisisUnitario>> {
        return analisisUnitarioObservable.getAnalisisUnitarios()
    }

    fun setAnalisisUnitariosInAdapter(analisisUnitarios: List<AnalisisUnitario>) {
        recyclerAnalisisAdapter?.setAnalisisList(analisisUnitarios)
        recyclerAnalisisAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerAnalisisAdapter(): RecyclerAnalisisAdapter? {
        recyclerAnalisisAdapter = RecyclerAnalisisAdapter(this, R.layout.cardview_analisis)
        return recyclerAnalisisAdapter
    }

    fun getAnalisisAt(position: Int): AnalisisUnitario? {
        var analisis: List<AnalisisUnitario>? = analisisUnitarioObservable.getAnalisisUnitarios().value
        return analisis?.get(position)
    }
}