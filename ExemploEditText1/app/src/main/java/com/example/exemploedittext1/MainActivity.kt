package com.example.exemploedittext1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var buttonCumprimentar: Button
    lateinit var textCumprimento: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNome = findViewById(R.id.editNome)
        buttonCumprimentar = findViewById(R.id.buttonCumprimentar)
        textCumprimento = findViewById(R.id.textCumprimento)

        buttonCumprimentar.setOnClickListener(){
            if(editNome.text.isEmpty()){
                Toast.makeText(this, "Digite seu nome", Toast.LENGTH_LONG).show()
            }else {
                textCumprimento.text = "Prazer em conhece-lo(a), ${editNome.text}"
            }
        }
    }
}