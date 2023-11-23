package com.example.listacompas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var editNomeItem: EditText
    lateinit var editQuantidadeItem: EditText
    lateinit var buttonAdicionar: Button
    lateinit var recyclerView: RecyclerView

    lateinit var lista: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNomeItem = findViewById(R.id.editNomeItem)
        editQuantidadeItem = findViewById(R.id.editQuantidadeItem)
        buttonAdicionar = findViewById(R.id.buttonAdicionar)
        recyclerView = findViewById(R.id.recyclerView)

        lista = mutableListOf<Item>()

        fun incluirItem() {

            //pegamos os valores digitados nos dois edits como strings
            val nome = editNomeItem.text.toString()
            val quantidade = editQuantidadeItem.text.toString()

            //se algum dos valores estiverem vazios nao podemos incluir
            //avisamos o usuarios com Toas e encerramos a função

            if (nome.isEmpty() || quantidade.isEmpty()){
                Toast.makeText(this, "Forneça nome e quantidade para incluir o item",
                    Toast.LENGTH_LONG).show()
                return
            }

            // criamos um novo objeto da classe item com o nome e quantidade informada pelo usuario
            val novoItem = Item(0, nome, quantidade.toInt())

            //adicionamos um novo item a lista
            lista.add(novoItem)

            //agora que houve uma mudança nos dados precisamos avisar o adapter para ele atuzalizar
            //a exibição do recycler View
            recyclerView.adapter?.notifyDataSetChanged()

            //apagamos os dados dos edits para uma nova inclusão
            editNomeItem.text.clear()
            editQuantidadeItem.text.clear()

            //posicionamos o cursor de digitação no campo do nome
            editNomeItem.requestFocus()

        }

        //instanciar o item adpter e passar para ele a lista de objetos (que ele internamente
        // se refere como dados

        val adapter = ItemAdapter(this, lista)

        //ligamos o recycler view ao adapter
        recyclerView.adapter = adapter

        //criamos um gerenciador de layout e atribuimos ele ao recyclerView
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        //para exibir uma linha divisoria entre cada item
        val decoration =DividerItemDecoration(this, layoutManager.orientation)
        recyclerView.addItemDecoration(decoration)

        //interceptamos o clique em uma linha do recyclerView e removemos
        //o item correspondente da lista
        adapter.onItemClick = {item ->
            lista.remove(item)
            adapter.notifyDataSetChanged()
        }

        buttonAdicionar.setOnClickListener {
            incluirItem()
        }

    }
}