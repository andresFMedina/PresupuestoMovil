package com.example.andresfelipe.presupuesto.model.detalle

import androidx.lifecycle.MutableLiveData

interface DetalleRepository {

    fun getDetalles(): MutableLiveData<List<Detalle>>
    fun callDetallesByAnalisisId(analisisId: Int)

}