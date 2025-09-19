package com.example.practicas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                //ISR
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var ingreso by remember { mutableStateOf("") }
    var isr by remember { mutableStateOf("") }
    var neto by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.isr),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ingreso Quincenal",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = ingreso,
            onValueChange = { ingreso = it },
            label = { Text("Ingresa tu sueldo") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val sueldo = ingreso.toDoubleOrNull() ?: 0.0
                val resultado = calcularISR(sueldo)

                isr = String.format("%.2f", resultado.first)
                neto = String.format("%.2f", resultado.second)
            },
            colors = ButtonDefaults.buttonColors(),
        ) {
            Text("CALCULAR")
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = isr,
            onValueChange = { isr = it },
            label = { Text("ISR") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = neto,
            onValueChange = { neto = it },
            label = { Text("Neto") }
        )
    }
}

fun calcularISR(ingreso: Double): Pair<Double, Double> {
    var isr = 0.0

    if (ingreso in 0.01..368.10) {
        isr = 0.00 + (ingreso - 0.01) * (1.92 / 100)
    } else if (ingreso in 368.11..3124.35) {
        isr = 7.05 + (ingreso - 368.11) * (6.40 / 100)
    } else if (ingreso in 3124.36..5490.75) {
        isr = 183.45 + (ingreso - 3124.36) * (10.88 / 100)
    } else if (ingreso in 5490.76..6382.80) {
        isr = 441.00 + (ingreso - 5490.76) * (16.00 / 100)
    } else if (ingreso in 6382.81..7641.90) {
        isr = 583.65 + (ingreso - 6382.81) * (17.92 / 100)
    } else if (ingreso in 7641.91..15412.80) {
        isr = 809.25 + (ingreso - 7641.91) * (21.36 / 100)
    } else if (ingreso in 15412.81..24292.65) {
        isr = 2469.15 + (ingreso - 15412.81) * (23.52 / 100)
    } else if (ingreso in 24292.66..46378.50) {
        isr = 4557.75 + (ingreso - 24292.66) * (30.00 / 100)
    } else if (ingreso in 46378.51..61838.10) {
        isr = 11183.40 + (ingreso - 46378.51) * (32.00 / 100)
    } else if (ingreso in 61838.11..185514.30) {
        isr = 16130.55 + (ingreso - 61838.11) * (34.00 / 100)
    } else if (ingreso >= 185514.31) {
        isr = 58180.35 + (ingreso - 185514.31) * (35.00 / 100)
    }

    val neto = ingreso - isr
    return Pair(isr, neto)
}