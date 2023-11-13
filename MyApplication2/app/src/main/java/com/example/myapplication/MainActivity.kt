package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textNome: TextView
    lateinit var textPreco: TextView
    lateinit var textPrecoDesconto: TextView

    lateinit var buttonExibirDados: Button

    val prod1 = Produto("Mouse", 99.99, 20)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonExibirDados = findViewById(R.id.buttonExibirDados)

        textNome = findViewById(R.id.textNome)
        textPreco = findViewById(R.id.textPreco)
        textPrecoDesconto = findViewById(R.id.textPrecoDesconto)

        buttonExibirDados.setOnClickListener{
            val ProdutoNome = prod1.obterNome()
            val ProdutoPreco = prod1.obterPreco()
            val ProdutoDesc = prod1.obterPrecoComDesconto()

            textNome.text = "${ProdutoNome}"

            textPreco.text = "${ProdutoPreco}"

            textPrecoDesconto.text = "${ProdutoDesc}"
        }
    }
}