package com.example.data
import java.util.Date
import java.text.SimpleDateFormat

class DataHora(){
    fun obterData(): String{
        var dataAtual = Date()
        var formatador = SimpleDateFormat("dd/MM/yyyy")
        return formatador.format(dataAtual)
    }

    fun obterHora(): String{
        var dataAtual = Date()
        var formatador = SimpleDateFormat("HH:mm")
        return formatador.format(dataAtual)
    }
}