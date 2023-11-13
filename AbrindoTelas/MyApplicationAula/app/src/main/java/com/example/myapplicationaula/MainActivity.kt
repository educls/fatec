package com.example.myapplicationaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var editMensagem: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editMensagem = findViewById(R.id.editMensagem)

        // Pra abrir uma nova tela declaramos um objeto da classe Intent
        // e no seu construtor passamos o nome da classe relativa á tela que
        // será aberta (segundaActivity neste caso)
        button.setOnClickListener(){

            intent = Intent(this, SegundaActivity::class.java)
            //antes de abrir a proxima tela, colocamos na intent o dadi que queremos enviar
            intent.putExtra("mensagem", editMensagem.text.toString())
            //Este comando faz então a abertura da tela
            startActivity(intent)
        }
    }
}