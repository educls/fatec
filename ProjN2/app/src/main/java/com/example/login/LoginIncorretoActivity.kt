package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginIncorretoActivity : AppCompatActivity() {

    lateinit var buttonVoltar: Button
    lateinit var TextMensagemIncorreto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_incorreto)

        setTitle("Login não Realizado");

        buttonVoltar = findViewById(R.id.buttonVoltar)

        TextMensagemIncorreto = findViewById(R.id.TextMensagemIncorreto)

        buttonVoltar.setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val mensagem = intent.getStringExtra("mensagem")
        TextMensagemIncorreto.text = mensagem

    }
}