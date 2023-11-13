package com.example.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textData: TextView
    lateinit var textHora: TextView

    lateinit var buttonData: Button
    lateinit var buttonHora: Button

    var dataHora: DataHora = DataHora()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textData = findViewById(R.id.textData)
        textHora = findViewById(R.id.textHora)

        buttonData = findViewById(R.id.buttonData)
        buttonHora = findViewById(R.id.buttonHora)

        buttonData.setOnClickListener(){
            textData.text = dataHora.obterData()
        }
        buttonHora.setOnClickListener(){
            textHora.text = dataHora.obterHora()
        }

    }
}