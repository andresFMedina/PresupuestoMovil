package com.example.andresfelipe.presupuesto.model.detalle

import com.example.andresfelipe.presupuesto.model.Item
import com.example.andresfelipe.presupuesto.model.analisisunitario.AnalisisUnitario
import com.google.gson.JsonObject
import java.io.Serializable

class Detalle(jsonObject: JsonObject): Serializable {

    var id: Int = 0
    var analisisUnitarioId: Int? = 0
    var analisisUnitario: AnalisisUnitario? = null
    var itemId: Int? = 0
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

    
    init {
        try {
            id = jsonObject.get("id").asInt
            rendimiento = jsonObject.get("rendimiento").asDouble
            codigo = jsonObject.get("codigo").asString
            descripcion = jsonObject.get("descripcion").asString
            unidad = jsonObject.get("unidad").asString
            precio = jsonObject.get("precio").asInt
            grupo = jsonObject.get("grupo").asString
            desperdicio = jsonObject.get("desperdicio").asDouble
            detalleDe = jsonObject.get("detalleDe").asString
            subTotal = jsonObject.get("subTotal").asInt
            analisisUnitarioId = jsonObject.get("analisisUnitarioId").asInt
            itemId = jsonObject.get("itemId").asInt
        } catch (e: Exception) {
            e.stackTrace
        }
    }
}