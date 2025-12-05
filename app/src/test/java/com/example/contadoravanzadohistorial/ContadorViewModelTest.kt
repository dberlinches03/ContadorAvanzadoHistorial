package com.example.contadoravanzadohistorial

import org.junit.Assert.*
import org.junit.Test
class ContadorViewModelTest {

    // Cada test se ejecuta con una nueva instancia del ViewModel
    private val viewModel = ContadorViewModel()

    // Casos de ÉXITO
    @Test
    fun sumarIncrementaContadorYRegistraHistorial() {
        viewModel.sumar()
        assertEquals(1, viewModel.contador.value)
        assertEquals("+1 -> contador = 1", viewModel.historial.last())
    }
    @Test
    fun restarDecrementaContadorYRegistraHistorial() {
        viewModel.restar()
        assertEquals(-1, viewModel.contador.value)
        assertEquals("-1 -> contador = -1", viewModel.historial.last())
    }
    @Test
    fun reiniciarRestableceContadorYRegistraHistorial() {
        viewModel.sumar()
        viewModel.reiniciar()
        assertEquals(0, viewModel.contador.value)
        assertEquals("reset -> contador = 0", viewModel.historial.last())
    }
    // CASOS DE ERROR (error path)
    // En este ejemplo no hay entradas inválidas porque los botones siempre llaman a funciones válidas.
    // Pero podemos comprobar que el historial no se actualiza si no se hace ninguna operación.
    @Test
    fun historialVacioAlInicio() {
        assertTrue(viewModel.historial.isEmpty())
    }
    // CASOS LÍMITE (boundary case)
    @Test
    fun reiniciarCuandoYaEstaEnCero() {
        viewModel.reiniciar()
        assertEquals(0, viewModel.contador.value)
        assertEquals("reset -> contador = 0", viewModel.historial.last())
    }
    @Test
    fun sumarVariasVeces() {
        repeat(5) { viewModel.sumar() }
        assertEquals(5, viewModel.contador.value)
        assertEquals("+1 -> contador = 5", viewModel.historial.last())
    }
}