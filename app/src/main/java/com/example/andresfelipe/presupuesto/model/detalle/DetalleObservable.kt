package com.example.andresfelipe.presupuesto.model.detalle

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class DetalleObservable: BaseObservable() {

    val detalleRepository: DetalleRepository = DetalleRepositoryImpl()

    fun callDetallesByAnalisisId(analisisId: Int){
        detalleRepository.callDetallesByAnalisisId(analisisId)
    }

    fun getDetalles():MutableLiveData<List<Detalle>> {
        return detalleRepository.getDetalles()
    }
}