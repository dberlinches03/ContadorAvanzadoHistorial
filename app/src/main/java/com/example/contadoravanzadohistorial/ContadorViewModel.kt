package com.example.contadoravanzadohistorial

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf

class ContadorViewModel : ViewModel() {
    private val _contador = mutableStateOf(0)
    val contador: State<Int> = _contador

    private val _historial = mutableStateListOf<String>()
    val historial: List<String> = _historial

    fun sumar() {
        _contador.value++
        _historial.add("+1 -> contador = ${contador.value}")
    }
    fun restar() {
        _contador.value--
        _historial.add("-1 -> contador = ${contador.value}")
    }
    fun reiniciar() {
        _contador.value = 0
        _historial.add("reset -> contador = 0")
    }
}