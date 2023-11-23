package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class listacomprasActivity : AppCompatActivity() {

    lateinit var editNomeItem: EditText
    lateinit var editQuantidadeItem: EditText
    lateinit var editPrecoItem: EditText
    lateinit var buttonAdicionar: Button
    lateinit var recyclerView: RecyclerView
    lateinit var textValorTotal: TextView
    lateinit var buttonVoltarCompras: Button

    lateinit var lista: MutableList<ItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listacompras)

        setTitle("Lista de Compras");

        editNomeItem = findViewById(R.id.editNomeItem)
        editQuantidadeItem = findViewById(R.id.editQuantidadeItem)
        editPrecoItem = findViewById(R.id.editPrecoItem)
        recyclerView = findViewById(R.id.recyclerView)
        buttonAdicionar = findViewById(R.id.buttonAdicionar)
        textValorTotal = findViewById(R.id.textValorTotal)
        buttonVoltarCompras = findViewById(R.id.buttonVoltarCompras)

        lista = mutableListOf<ItemModel>()


        val mensagem = intent.getStringExtra("mensagem")
        buttonVoltarCompras.setOnClickListener(){
            intent = Intent(this, LoginCorretoActivity::class.java)
            intent.putExtra("mensagem", mensagem)
            startActivity(intent)
        }

        buttonAdicionar.setOnClickListener {
            incluirItem()
        }

        val adapter = ItemAdapter(this, lista)

        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val decoration = DividerItemDecoration(this, layoutManager.orientation)
        recyclerView.addItemDecoration(decoration)

        adapter.onItemClick = {item ->
            lista.remove(item)
            adapter.notifyDataSetChanged()
        }
    }

    fun somarPrecos(lista: MutableList<ItemModel>): Float {
        return lista.sumByDouble { it.preco.toDouble() }.toFloat()
    }

    fun atualizarValorTotal() {
        val totalPrecos = somarPrecos(lista)
        textValorTotal.text = totalPrecos.toString()
    }
    fun incluirItem() {
        val nome = editNomeItem.text.toString()
        val quantidade = editQuantidadeItem.text.toString().toInt()
        val textPreco = editPrecoItem.text.toString().toFloat()
        val preco = textPreco * quantidade

        if (nome.isEmpty() || quantidade.toString().isEmpty() || textPreco.toString().isEmpty()){
            Toast.makeText(this, "Forneça nome, quantidade e preco",
                Toast.LENGTH_LONG).show()
            return
        }

        val novoItem = ItemModel(0, nome, quantidade, preco)

        atualizaPreco(novoItem.preco)

        lista.add(novoItem)
        recyclerView.adapter?.notifyDataSetChanged()

        editNomeItem.text.clear()
        editQuantidadeItem.text.clear()
        editPrecoItem.text.clear()

        editNomeItem.requestFocus()
    }

    fun atualizaPreco(preco: Float){
        var precoTextView = textValorTotal.text.toString().toFloat()
        var total = precoTextView + preco

        textValorTotal.setText(total.toString())

    }
}