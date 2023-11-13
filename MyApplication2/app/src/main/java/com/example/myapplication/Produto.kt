package com.example.myapplication

class Produto(var nomeProduto: String,
              var preco: Double,
              var descVista: Int) {

    fun obterNome(): String {
        return nomeProduto.uppercase()
    }

    fun obterPreco(): String {
        return String.format("R$ %.2f", preco)
    }

    fun obterPrecoComDesconto(): String {
        val valorDesconto = preco * (descVista / 100.0)
        val precoComDesconto = preco - valorDesconto
        return String.format("R$ %.2f", precoComDesconto)
    }
}