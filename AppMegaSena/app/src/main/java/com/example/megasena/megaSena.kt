package com.example.megasena

class MegaSena(var nros: Int = 60) {

    fun sortear(): MutableList<Int> {
        val lista = mutableListOf<Int>()

        val intervalo = 1..nros

        while (lista.size < 6) {
            val numSorteado = intervalo.random()

            if (!lista.contains(numSorteado)) {
                lista.add(numSorteado)
            }
        }
        lista.sort()
        return lista
    }
}