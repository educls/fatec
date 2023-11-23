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

class dataActivity : AppCompatActivity() {

    lateinit var handler: Handler
    lateinit var runnable: Runnable
    lateinit var textData: TextView
    lateinit var textHora: TextView
    lateinit var buttonVoltarData: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        setTitle("Data/Hora ao vivo");

        textData = findViewById(R.id.textData)
        textHora = findViewById(R.id.textHora)
        buttonVoltarData = findViewById(R.id.buttonVoltarData)

        val mensagem = intent.getStringExtra("mensagem")

        buttonVoltarData.setOnClickListener(){
            intent = Intent(this, LoginCorretoActivity::class.java)
            intent.putExtra("mensagem", mensagem)
            startActivity(intent)
        }

        handler = Handler()
        runnable = object : Runnable {
            override fun run() {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val dateFormat1 = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                val date = Date()
                val dateData = dateFormat.format(date)
                val dateHora = dateFormat1.format(date)

                textData.text = dateData
                textHora.text = dateHora

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}