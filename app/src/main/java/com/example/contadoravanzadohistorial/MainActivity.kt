package com.example.contadoravanzadohistorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.contadoravanzadohistorial.ui.theme.ContadorAvanzadoHistorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorAvanzadoHistorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Contador(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Contador(
    modifier: Modifier = Modifier,
    viewModel: ContadorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Column (
        Modifier.fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text("Contador de operaciones")
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Resultado: ${viewModel.contador.value}")
        Spacer(modifier = Modifier.padding(8.dp))

        Row {
            Button(onClick = { viewModel.sumar() }) { Text("Sumar") }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(onClick = { viewModel.restar() }) { Text("Restar") }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(onClick = { viewModel.reiniciar() }){ Text("Reiniciar") }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text("Historial de operaciones")
        viewModel.historial.forEach { operacion ->
            Text(operacion)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContadorPreview() {
    ContadorAvanzadoHistorialTheme {
        Contador()
    }
}