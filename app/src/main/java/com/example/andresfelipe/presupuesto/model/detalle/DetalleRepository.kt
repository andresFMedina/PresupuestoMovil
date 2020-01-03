package com.example.andresfelipe.presupuesto.model.detalle

interface DetalleRepository {

    fun getDetallesByAnalisisId(analisisId: Int): MutableListIterator<List<Detalle>>
    fun callPresupuestoApi()
}