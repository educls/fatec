package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SorteadorActivity : AppCompatActivity() {

    lateinit var textMensagemSorteio: TextView
    lateinit var textNumSort: TextView
    lateinit var buttonSotear: Button
    lateinit var buttonVoltarSorteio: Button
    var numeros: Numeros = Numeros(nros = 60)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorteador)

        setTitle("Sorteador de Números");

        val mensagem = intent.getStringExtra("mensagem")

        buttonVoltarSorteio = findViewById(R.id.buttonVoltarSorteio)
        textMensagemSorteio = findViewById(R.id.textMensagemSorteio)
        textNumSort = findViewById(R.id.textNumSort)
        buttonSotear = findViewById(R.id.buttonSortear)

        buttonSotear.setOnClickListener(){
            val numerosSorteados = numeros.sortear()
            textMensagemSorteio.text = "Numeros Sorteados"
            textNumSort.text = "$numerosSorteados"
        }
        buttonVoltarSorteio.setOnClickListener(){
            intent = Intent(this, LoginCorretoActivity::class.java)
            intent.putExtra("mensagem", mensagem)
            startActivity(intent)
        }
    }
}