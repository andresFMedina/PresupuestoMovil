package com.example.andresfelipe.presupuesto.model.analisisunitario

import com.example.andresfelipe.presupuesto.model.detalle.Detalle
import com.example.andresfelipe.presupuesto.model.Proyecto
import com.google.gson.JsonObject
import java.io.Serializable

class AnalisisUnitario(jsonObject: JsonObject?): Serializable {

    var id: Int = 0
    var proyectoId: Int = 0
    lateinit var proyecto: Proyecto
    lateinit var codigo: String
    lateinit var descripcion:  String
    lateinit var unidad: String
    var grupo: String? = null
    var valorUnitario: Int = 0
    lateinit var detalles: List<Detalle>

    init {
        try {
            id = jsonObject!!.get("id").asInt
            proyectoId = jsonObject!!.get("proyectoId").asInt
            codigo = jsonObject!!.get("codigo").asString
            descripcion = jsonObject!!.get("descripcion").asString
            unidad = jsonObject!!.get("unidad").asString
            valorUnitario = jsonObject!!.get("valorUnitario").asInt
            grupo = jsonObject!!.get("grupo").asString
        }
        catch (ex: Exception) {
            ex.stackTrace
        }

    }

}