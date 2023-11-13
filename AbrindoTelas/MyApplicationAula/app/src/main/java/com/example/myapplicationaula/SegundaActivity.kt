package com.example.myapplicationaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {

    lateinit var button2: Button
    lateinit var textMensagem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        button2 = findViewById(R.id.button2)
        textMensagem = findViewById(R.id.textMensagem)

        val mensagem = intent.getStringExtra("mensagem")
        textMensagem.text = mensagem

        button2.setOnClickListener{ finish() }
    }
}