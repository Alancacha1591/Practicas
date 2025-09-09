package com.example.practicas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                    )
                }
            }
        }
    }

    @Composable
    fun Greeting() {
        val context= LocalContext.current
        var ValorA by remember { mutableStateOf("") }
        var ValorB by remember { mutableStateOf("") }
        var Resultado by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(Modifier.padding(16.dp)){
                OutlinedTextField(
                    value=ValorA,
                    label={Text("Valor A")},
                    onValueChange ={ValorA=it}
                )
            }
            Row(Modifier.padding(16.dp)){
                OutlinedTextField(
                    value=ValorB,
                    label={Text("Valor B")},
                    onValueChange ={ValorB=it}
                )
            }
            Row(
                Modifier.align(Alignment.CenterHorizontally)
            ){
                OutlinedButton(onClick = { /*TODO*/
                        val a = ValorA.toInt()
                        val b = ValorB.toInt()
                        val c = a+b
                        Resultado = c.toString()
                }) {
                    Text(text = "Enviar")
                }
                OutlinedButton(onClick = { /*TODO*/
                    Resultado = " "
                }) {
                    Text(text = "Borrar")
                }
            }
            Row(
                Modifier.align(Alignment.CenterHorizontally)
            ){
                OutlinedTextField(
                    value=Resultado,
                    label={Text("Resultado")},
                    onValueChange ={Resultado=it}
                )
            }
        }
    }
}