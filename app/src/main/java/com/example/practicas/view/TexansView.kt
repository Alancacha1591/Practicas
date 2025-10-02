package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.components.MainIconButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TexansView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    MainIconButton(
                        icon = Icons.Filled.ArrowBack,
                        onClick = { navController.navigate("AFC") }
                    )
                },
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.toptexans),
                        contentDescription = "Texans Logo",
                        modifier = Modifier.height(50.dp)
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF6D6D82)
                )
            )
        },
    ){ paddingValues ->

        // 1. INICIO DEL BOX: Ocupa toda el área del Scaffold
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // 2. PRIMER ELEMENTO: IMAGEN DE FONDO
            // Esta imagen queda en la capa más profunda
            Image(
                // Usamos la misma imagen de fondo
                painter = painterResource(id = R.drawable.stroudback),
                contentDescription = "Fondo Temático NFL",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                // La opacidad (alpha) ayuda a que la imagen no distraiga del texto
                alpha = 0.7f
            )

            // 3. SEGUNDO ELEMENTO: EL CONTENIDO PRINCIPAL
            // Esta es la capa superior, donde está tu Column deslizable
            ContentTexansView(paddingValues)
        }
    }
}

@Composable
fun ContentTexansView(paddingValues: PaddingValues){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp) // Padding general para la vista
            .verticalScroll(scrollState), // <--- Habilita el desplazamiento
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- 1. CABECERA Y VIGENCIA ---
        HeaderTexans()
        Space(30)

        // --- 2. RESUMEN/DESCRIPCIÓN ---
        TextView("DESCRIPCIÓN") // Nuevo componente de cabecera de sección
        Space(20)
        Text(
            text = "Son un equipo profesional de fútbol americano de los Estados Unidos con sede en Houston, Texas. Compiten en la División Sur de la Conferencia Americana (AFC) de la National Football League (NFL)",
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), // Aplicamos padding para que no se pegue a los lados
            textAlign = TextAlign.Center // <--- CAMBIO CLAVE: Centra el texto
        )
        Space(30)

        // --- 3. CAMPEONATOS ---
        TextView("CAMPEONATOS")
        Space(20)
        ChampionshipsTexans()
        Space(30)

        // --- 4. TOP PLAYER & HEAD COACH ---
        LeadersTexans()
        Space(30)

        // --- 5. UNIFORMES Y CASCO (HELMET) ---
        TextView("HELMET")
        Space(20)
        TexansHelmet()
        Space(30)

        TextView("UNIFORMS")
        TexansUniforms()
        Space(10)

        // --- 6. ESTADIO ---
        TextView("ESTADIO")
        Space(10)
        StadiumTexans()
        Space(30)
    }
}

@Composable
fun HeaderTexans() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo (Lado Izquierdo)
        Image(
            painter = painterResource(id = R.drawable.texans),
            contentDescription = "Texans Logo Grande",
            modifier = Modifier
                .size(100.dp)
                .weight(0.4f)
        )
        // Nombre y Vigencia (Lado Derecho)
        Column(modifier = Modifier.weight(0.6f).padding(start = 8.dp)) {
            Text(text = "Houson Texans", fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
            Text(text = "2002-presente", fontSize = 20.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ChampionshipsTexans() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Títulos Divisionales
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.achamp), contentDescription = "Títulos", modifier = Modifier.height(120.dp))
            Text(text = "0 Títulos", fontWeight = FontWeight.Bold)
            Text(text = "-----------", fontSize = 15.sp)
        }
        // Super Bowls
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.sb), contentDescription = "Super Bowl", modifier = Modifier.height(120.dp))
            Text(text = "0 Super Bowls", fontWeight = FontWeight.Bold)
            Text(text = "----------", fontSize = 15.sp)
        }
    }
}

@Composable
fun LeadersTexans() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // --- 1. Top Player (Lamar Jackson) ---
        Column(
            modifier = Modifier.weight(1f).padding(end = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabecera "Top Player" (Simulación de texto en negrita)
            Text(text = "Top Player", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)

            // Imagen del Jugador
            Image(
                // Asume que tienes R.drawable.lamar_jackson
                painter = painterResource(id = R.drawable.stroud),
                contentDescription = "C.J. Stroud",
                // Ajusta la altura para que las cabezas queden alineadas
                modifier = Modifier.height(150.dp).width(150.dp)
            )

            // Datos del Jugador
            Text(text = "C.J. Stroud", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "#07 QB", fontSize = 16.sp, textAlign = TextAlign.Center)
        }

        Column(
            modifier = Modifier.weight(1f).padding(start = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabecera "Head Coach"
            Text(text = "Head Coach", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)

            // Imagen del Entrenador
            Image(
                // Asume que tienes R.drawable.john_harbaugh
                painter = painterResource(id = R.drawable.hctexans),
                contentDescription = "Sean McDermott",
                // Misma altura que el jugador para simetría
                modifier = Modifier.height(150.dp).width(150.dp)
            )

            // Datos del Entrenador
            Text(text = "DeMeco Ryans", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "(2023–present)", fontSize = 16.sp, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun TexansHelmet() {
    Image(painter = painterResource(id = R.drawable.helmettexans), contentDescription = "Casco Ravens", modifier = Modifier.height(150.dp))
}

@Composable
fun TexansUniforms() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Aquí irían los tres composables de uniforme
        // Uniforme Color, Uniforme White, Uniforme Alternate
        Image(painter = painterResource(id = R.drawable.uniformtexans), contentDescription = "Uniforme Color", modifier = Modifier.height(250.dp))
    }
}

@Composable
fun StadiumTexans() {
    // Usar una Card o un Box para el fondo de la imagen del estadio si quieres un borde
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.stadiumtexans), contentDescription = "M&T Bank Stadium", modifier = Modifier.height(150.dp))
        Space(10)
        Text(text = "NRG Stadium", fontWeight = FontWeight.ExtraBold)
        Text(text = "Capacidad 72 220")
        Text(text = "Coste \$352 000 000 USD")
    }
}