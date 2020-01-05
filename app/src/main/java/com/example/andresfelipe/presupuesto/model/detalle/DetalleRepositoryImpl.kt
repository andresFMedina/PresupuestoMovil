package com.example.andresfelipe.presupuesto.model.detalle

import androidx.lifecycle.MutableLiveData
import com.example.andresfelipe.presupuesto.model.ApiAdapter
import com.example.andresfelipe.presupuesto.utils.Constants
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalleRepositoryImpl: DetalleRepository {

    private var detalles = MutableLiveData<List<Detalle>>()

    override fun getDetalles(): MutableLiveData<List<Detalle>> {
        return detalles
    }

    override fun callDetallesByAnalisisId(analisisId: Int) {
        val detallesList: ArrayList<Detalle>? =  ArrayList()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getDetalleListByAnalisisId(analisisId)

        call.enqueue(object: Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val detallesJsonArray = response.body()?.getAsJsonArray(Constants.MODEL)
                detallesJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val detalle = Detalle(jsonObject)
                    detallesList?.add(detalle)
                }

                detalles.value = detallesList
            }

        })
    }



}