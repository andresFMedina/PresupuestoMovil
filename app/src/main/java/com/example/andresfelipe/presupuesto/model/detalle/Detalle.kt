package com.example.andresfelipe.presupuesto.model.detalle

import com.example.andresfelipe.presupuesto.model.Item
import com.example.andresfelipe.presupuesto.model.analisisunitario.AnalisisUnitario
import com.google.gson.JsonObject
import java.io.Serializable

class Detalle(jsonObject: JsonObject): Serializable {

    var id: Int = 0
    var analisisUnitarioId: Int = 0
    var analisisUnitario: AnalisisUnitario? = null
    var itemId: Int = 0
    var item: Item? = null
    var rendimiento: Double = 0.0
    lateinit var codigo: String
    lateinit var descripcion: String
    lateinit var unidad: String
    var precio: Int = 0
    var grupo: String? = null
    var desperdicio: Double = 0.0
    lateinit var detalleDe: String
    var subTotal: Int = 0

}