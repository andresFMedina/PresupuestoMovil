package com.example.andresfelipe.presupuesto.model.analisisunitario

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.andresfelipe.presupuesto.model.ApiAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnalisisUnitarioRepositoryImpl: AnalisisUnitarioRepository {

    private var analisisUnitarios = MutableLiveData<List<AnalisisUnitario>>()

    override fun getAnalisisUnitarioList(): MutableLiveData<List<AnalisisUnitario>> {
        return analisisUnitarios
    }

    override fun callPresupuestoApi() {
        var analisisList: ArrayList<AnalisisUnitario>? = ArrayList<AnalisisUnitario>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getAnalisisUnitarioList()

        call.enqueue(object :Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val analisisJsonArray = response.body()?.getAsJsonArray("model")
                analisisJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var analisisUnitario = AnalisisUnitario(jsonObject)
                    analisisList?.add(analisisUnitario)
                }

                analisisUnitarios.value = analisisList
            }
        })
    }
}