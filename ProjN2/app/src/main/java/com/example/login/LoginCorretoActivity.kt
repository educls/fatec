package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LoginCorretoActivity : AppCompatActivity() {

    lateinit var TextMensagemCorreto: TextView
    lateinit var buttonDataHora: Button
    lateinit var buttonSair: Button
    lateinit var buttonSorteador: Button
    lateinit var buttonListaCompras: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_correto)

        setTitle("Menu Principal");

        buttonSair = findViewById(R.id.buttonSair)
        TextMensagemCorreto = findViewById(R.id.TextMensagemCorreto)
        buttonDataHora = findViewById(R.id.buttonDataHora)
        buttonSorteador = findViewById(R.id.buttonSorteador)
        buttonListaCompras = findViewById(R.id.buttonListaCompras)

        val mensagem = intent.getStringExtra("mensagem")
        TextMensagemCorreto.text = mensagem

        buttonListaCompras.setOnClickListener(){
            intent = Intent(this, listacomprasActivity::class.java)
            intent.putExtra("mensagem", mensagem)
            startActivity(intent)
        }
        buttonSorteador.setOnClickListener(){
            intent = Intent(this, SorteadorActivity::class.java)
            intent.putExtra("mensagem", mensagem)
            startActivity(intent)
        }
        buttonSair.setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonDataHora.setOnClickListener(){
            intent = Intent(this, dataActivity::class.java)
            intent.putExtra("mensagem", mensagem)
            startActivity(intent)
        }
    }

}