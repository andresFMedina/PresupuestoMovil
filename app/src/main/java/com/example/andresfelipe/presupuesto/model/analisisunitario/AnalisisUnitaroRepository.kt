package com.example.andresfelipe.presupuesto.model.analisisunitario

import androidx.lifecycle.MutableLiveData

interface AnalisisUnitarioRepository {

    fun getAnalisisUnitarioList(): MutableLiveData<List<AnalisisUnitario>>
    fun callAnalisisUnitarioList()
}