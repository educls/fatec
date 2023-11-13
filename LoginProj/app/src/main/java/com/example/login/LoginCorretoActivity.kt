package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginCorretoActivity : AppCompatActivity() {

    lateinit var TextMensagemCorreto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_correto)

        TextMensagemCorreto = findViewById(R.id.TextMensagemCorreto)

        val mensagem = intent.getStringExtra("mensagem")
        TextMensagemCorreto.text = mensagem
    }
}