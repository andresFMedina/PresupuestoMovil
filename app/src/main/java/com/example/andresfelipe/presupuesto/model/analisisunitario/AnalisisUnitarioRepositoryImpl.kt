package com.example.andresfelipe.presupuesto.model.analisisunitario

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.andresfelipe.presupuesto.model.ApiAdapter
import com.example.andresfelipe.presupuesto.utils.Constants
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

    override fun callAnalisisUnitarioList() {
        val analisisList: ArrayList<AnalisisUnitario>? = ArrayList()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getAnalisisUnitarioList()

        call.enqueue(object :Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val analisisJsonArray = response.body()?.getAsJsonArray(Constants.MODEL)
                analisisJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val analisisUnitario = AnalisisUnitario(jsonObject)
                    analisisList?.add(analisisUnitario)
                }

                analisisUnitarios.value = analisisList
            }
        })
    }
}