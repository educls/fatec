package com.example.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //declaramos no inicio da mainActivity os objetos da interface que usaremos dentro
    // deste codigo neste caso estamos declarando um objeto chamado textView da classe
    // TextView para importar a classe podemos digitar seu nome e usar o autocompletar
    // ou clicar em cima do nome da classe e digitar alt + enter
    //lateinit var textView: TextView

    lateinit var imageView: ImageView

    // a proxima linha declara o button existente na interface e ele é um objeto
    // da classe button que tbm precisa ser importada como a TextView foi
    lateinit var button: Button

    //criamos um objeto dado da classe Dado com 6 lados este será o dado "rolado" quando o
    //usuario clicar no botão
    var dado: Dado = Dado(lados = 6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //o comando findViewById busca por um widget na interface o traz para o codigo
        // da mainActivity inicializando assim os objetos locais textView e button e
        // fazendo com que eles apontem para seu respectivo elemento da interface 
        //textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        imageView = findViewById(R.id.imageView)

        button.setOnClickListener{
            //A classe toast permite a criação e exibição de uma mensagem rapida
            //a função "mainText" cria a mensagem passando o texto a ser exibido como
            //o segundo parametro e o tempo de exibição como o terceiro por fim a
            //função show exibe a mensagem
            Toast.makeText(this, "Dado Rolado", Toast.LENGTH_SHORT).show()
            //textView.text = "${dado.rolar()}"

            //A estrutura when testa o valor retornado pela execução da função
            //"dado.rolar()". Dentro das chaves para cada valor possivel é colocado
            //um procedimento correspondente
            when(dado.rolar()){
                1 -> imageView.setImageResource(R.drawable.dado_1)
                2 -> imageView.setImageResource(R.drawable.dado_2)
                3 -> imageView.setImageResource(R.drawable.dado_3)
                4 -> imageView.setImageResource(R.drawable.dado_4)
                5 -> imageView.setImageResource(R.drawable.dado_5)
                6 -> imageView.setImageResource(R.drawable.dado_6)
            }
        }
    }
}