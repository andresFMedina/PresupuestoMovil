package com.example.andresfelipe.presupuesto.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.andresfelipe.presupuesto.R
import com.example.andresfelipe.presupuesto.databinding.ActivityMainBinding
import com.example.andresfelipe.presupuesto.model.analisisunitario.AnalisisUnitario
import com.example.andresfelipe.presupuesto.viewmodel.AnalisisUnitarioViewModel

class MainActivity : AppCompatActivity() {

    private var analisisUnitarioViewModel: AnalisisUnitarioViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBindings(savedInstanceState)
    }

    private fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        analisisUnitarioViewModel = ViewModelProviders.of(this).get(AnalisisUnitarioViewModel::class.java)

        activityMainBinding.setModel(analisisUnitarioViewModel)
        setupListUpdate()
    }

    private fun setupListUpdate() {
        analisisUnitarioViewModel?.callPresupuesto()
        analisisUnitarioViewModel?.getAnalisisUnitarios()?.observe(this, Observer {
            analisis: List<AnalisisUnitario> ->
            Log.w("Analisis", analisis.get(0).toString())
            analisisUnitarioViewModel?.setAnalisisUnitariosInAdapter(analisis)
        })
    }
}
