package com.example.andresfelipe.presupuesto.model.analisisunitario

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData


class AnalisisUnitarioObservable: BaseObservable() {

    private var analisisUnitarioRepository: AnalisisUnitarioRepository = AnalisisUnitarioRepositoryImpl()

    fun callPresupuesto(){
        analisisUnitarioRepository.callPresupuestoApi()
    }

    fun getAnalisisUnitarios(): MutableLiveData<List<AnalisisUnitario>> {
        return analisisUnitarioRepository.getAnalisisUnitarioList()
    }
}