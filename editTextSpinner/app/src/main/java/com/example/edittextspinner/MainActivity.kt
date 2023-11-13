package com.example.edittextspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

lateinit var editNum1: EditText
lateinit var editNum2: EditText

lateinit var spinnerOperacao: Spinner

lateinit var buttonCalcular: Button

lateinit var textResultado: TextView

val operacoes = listOf("ADIÇÃO", "SUBTRAÇÃO", "MULTIPLICAÇÃO", "DIVISÃO")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNum1 = findViewById(R.id.editNum1)
        editNum2 = findViewById(R.id.editNum2)

        spinnerOperacao = findViewById(R.id.spinnerOperacao)

        buttonCalcular = findViewById(R.id.buttonCalcular)

        textResultado = findViewById(R.id.textResultado)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operacoes)

        spinnerOperacao.adapter = adapter

        buttonCalcular.setOnClickListener{ calcular()}
    }
    fun calcular(){

        if (editNum1.text.isEmpty() || editNum2.text.isEmpty()){
            Toast.makeText(this, "Digite os dois numeros", Toast.LENGTH_LONG).show()
            return
        }

        val numero1 = editNum1.text.toString().toDouble()
        val numero2 = editNum2.text.toString().toDouble()

        val operacao = spinnerOperacao.selectedItemPosition

        when (operacao){
            0 -> textResultado.text = "${numero1 + numero2}"
            1 -> textResultado.text = "${numero1 - numero2}"
            2 -> textResultado.text = "${numero1 * numero2}"
            3 -> textResultado.text = "${numero1 / numero2}"
        }
    }
}
