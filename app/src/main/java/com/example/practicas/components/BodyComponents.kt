package com.example.practicas.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextView(texto:String){
    Text(text = texto,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,)
}

@Composable
fun TextViewHV(texto:String, modifier: Modifier = Modifier){
    Text(
        text = texto,
        fontSize = 32.sp, // <--- CAMBIO 1: Reducir a 32.sp para evitar corte.
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier, // <--- CAMBIO 2: APLICA el modifier (Modifier.fillMaxWidth())
        textAlign = TextAlign.Center // <--- CAMBIO 3: Fuerza el centrado del texto
    )
}

@Composable
fun Space(espacio:Int){
    Spacer(modifier = Modifier.height(espacio.dp))
}

@Composable
fun MainButton(name:String, backColor:Color,
                color:Color, onClick:() -> Unit){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        )
    ) {
        Text(text = name)
    }
}

@Composable
fun MainButtonLogo(
    modifier: Modifier = Modifier,
    backColor: Color,
    color: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        )
    ) {
        content()
    }
}

// Auxiliar: Componente TeamCard dentro de AmericanaView.kt

@Composable
fun TeamCard(
    navController: NavController,
    modifier: Modifier = Modifier, // <--- CAMBIO 1: Acepta un Modifier
    route: String,
    backColor: Color,
    logoId: Int,
    division: String,
    teamName: String
) {
    Button(
        onClick = { navController.navigate(route) },
        // APLICAMOS el modifier que viene desde ContentAmericanaView
        modifier = modifier.fillMaxWidth(), // <--- CAMBIO 2: Aplica el Modifier
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backColor,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Lado Izquierdo: LOGO
            Image(
                painter = painterResource(id = logoId),
                contentDescription = "$teamName Logo",
                modifier = Modifier
                    .weight(0.4f) // Ocupa un 40% del ancho
                    .aspectRatio(1f) // Esto lo hace cuadrado
                    .padding(10.dp)
            )

            // Lado Derecho: TEXTO
            Column(
                modifier = Modifier
                    .weight(0.6f) // Ocupa un 60% del ancho restante
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.End // Alinea el texto a la derecha
            ) {
                // Nombre de la División
                Text(text = division, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                // Nombre del Equipo
                Text(text = teamName, fontSize = 19.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}