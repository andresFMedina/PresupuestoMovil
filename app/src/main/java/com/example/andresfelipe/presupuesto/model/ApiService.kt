package com.example.andresfelipe.presupuesto.model

import com.example.andresfelipe.presupuesto.utils.Constants
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////Analisis Unitario////////////////////////////////////////
    @GET(Constants.ANALISIS_UNITARIO)
    fun getAnalisisUnitarioList(): Call<JsonObject>
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////Detalle//////////////////////////////////////////////////
    @GET(Constants.DETALLE)
    fun getDetalleListByAnalisisId(@Query(Constants.ANALISIS_ID_FILTER) analisisId: Int): Call<JsonObject>
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////Item/////////////////////////////////////////////////////
    @GET(Constants.ITEM)
    fun getItemListByProyecto(proyectoId: Int): Call<JsonObject>
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////Recurso Basico///////////////////////////////////////////
    @GET(Constants.RECURSO_BASICO)
    fun getRecursoBasicoList(): Call<JsonObject>
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

}