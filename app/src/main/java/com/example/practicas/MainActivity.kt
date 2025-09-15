package com.example.practicas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var pantalla by remember { mutableStateOf("0") }
    var historial by remember { mutableStateOf("") }
    var primerNumero by remember { mutableStateOf<Double?>(null) }
    var operacion by remember { mutableStateOf<String?>(null) }
    var operadorPresionado by remember { mutableStateOf(false) }

    fun limpiar() {
        pantalla = "0"
        historial = ""
        primerNumero = null
        operacion = null
    }

    fun borrarUltimo() {
        pantalla = if (pantalla.length > 1) {
            pantalla.dropLast(1)
        } else "0"
    }

    fun agregarNumero(num: String) {
        pantalla = if (pantalla == "0" || operadorPresionado) {
            num
        } else {
            pantalla + num
        }
        operadorPresionado = false
    }

    fun agregarDecimal() {
        if (!pantalla.contains(".")) pantalla += "."
    }

    fun elegirOperacion(op: String) {
        val numero = pantalla.toDoubleOrNull() ?: return
        if (primerNumero == null) {
            primerNumero = numero
        } else if (operacion != null) {
            primerNumero = calcular(primerNumero!!, numero, operacion!!)
            pantalla = formatearResultado(primerNumero!!)
        }
        operacion = op
        historial += " ${pantalla} $op"
        operadorPresionado = true
    }

    fun calcularResultado() {
        val segundoNumero = pantalla.toDoubleOrNull() ?: return
        if (primerNumero != null && operacion != null) {
            val resultado = calcular(primerNumero!!, segundoNumero, operacion!!)
            historial += " $pantalla ="
            pantalla = if (resultado.isNaN()) "Error" else formatearResultado(resultado)
            primerNumero = null
            operacion = null
        }
    }


    //Interfaz
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp,50.dp,10.dp, 0.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
        ) {
            Text(historial, color = Color.Gray, fontSize = 28.sp, maxLines = 1)
            Text(pantalla, color = Color.Black, fontSize = 60.sp, fontWeight = FontWeight.Bold)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val botones = listOf(
                listOf("C", "⌫"),
                listOf("7", "8", "9", "/"),
                listOf("4", "5", "6", "*"),
                listOf("1", "2", "3", "-"),
                listOf("0", ".", "+"),
                listOf("=")
            )

            botones.forEach { fila ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    fila.forEach { texto ->
                        Button(
                            onClick = {
                                when (texto) {
                                    in "0".."9" -> agregarNumero(texto)
                                    "." -> agregarDecimal()
                                    "C" -> limpiar()
                                    "⌫" -> borrarUltimo()
                                    "+", "-", "*", "/" -> elegirOperacion(texto)
                                    "=" -> calcularResultado()
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(70.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (texto in listOf("+", "-", "*", "/", "="))
                                    Color.Red else Color(0xFFDDDDDD),
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(texto, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

//Calculadora
fun calcular(a: Double, b: Double, op: String): Double {
    return when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> if (b == 0.0) Double.NaN else a / b
        else -> b
    }
}

fun formatearResultado(num: Double): String {
    return if (num % 1 == 0.0) num.toInt().toString() else num.toString()
}