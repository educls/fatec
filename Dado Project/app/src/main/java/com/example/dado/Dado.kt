package com.example.dado

class Dado(var lados: Int = 6){

    fun rolar(): Int{
        var intervalo = 1..lados
        var numeroSorteado = intervalo.random()
        return numeroSorteado
    }
}