package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var buttonEntrar: Button
    lateinit var editLogin: EditText
    lateinit var editSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        val lista = listOf("eduardo", "1234", "roberto", "4321", "marcos", "9876")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEntrar = findViewById(R.id.buttonEntrar)
        editLogin = findViewById(R.id.editLogin)
        editSenha = findViewById(R.id.editSenha)

        buttonEntrar.setOnClickListener(){

            val editLogin = findViewById<EditText>(R.id.editLogin)
            val textoDigitadoLogin = editLogin.text.toString()

            val editSenha = findViewById<EditText>(R.id.editSenha)
            val textoDigitadoSenha = editSenha.text.toString()

            if (lista.contains(textoDigitadoLogin) && lista.contains(textoDigitadoSenha)) {
                intent = Intent(this, LoginCorretoActivity::class.java)
                intent.putExtra("mensagem", "Bem Vindo(a), $textoDigitadoLogin")
                startActivity(intent)
            } else {
                intent = Intent(this, LoginIncorretoActivity::class.java)
                intent.putExtra("mensagem", "Erro no Login")
                startActivity(intent)
            }

        }

    }
}