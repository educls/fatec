package com.example.megasena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var buttonSortear: Button
    var numeros: MegaSena = MegaSena(nros = 60)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSortear = findViewById(R.id.buttonSortear)

        textView = findViewById(R.id.textView)

        buttonSortear.setOnClickListener{
            val numerosSorteados = numeros.sortear()
            textView.text = "Números sorteados: ${numerosSorteados}"
        }

    }
}