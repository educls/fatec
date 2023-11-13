package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginIncorretoActivity : AppCompatActivity() {

    lateinit var TextMensagemIncorreto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_incorreto)

        TextMensagemIncorreto = findViewById(R.id.TextMensagemIncorreto)

        val mensagem = intent.getStringExtra("mensagem")
        TextMensagemIncorreto.text = mensagem

    }
}