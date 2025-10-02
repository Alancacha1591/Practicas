package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practicas.components.MainIconButton
import com.example.practicas.R
import com.example.practicas.components.TeamCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NacionalView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    MainIconButton(
                        icon = Icons.Filled.ArrowBack, // Icono de flecha
                        onClick = { navController.navigate("Home") } // Vuelve a HomeView
                    )
                },
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.nfc), // <-- Asumiendo que el logo de AFC está aquí
                        contentDescription = "NFC Logo",
                        modifier = Modifier.height(35.dp) // Ajusta el tamaño del logo en la barra
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    // Color Rojo NFL (usando el hexadecimal que definimos)
                    containerColor = Color(0xFF103C65)
                )
            )
        },
    ){ paddingValues -> // <--- PASO CLAVE 1: Capturar el padding
        // PASO CLAVE 2: Pasar el padding a la función de contenido
        ContentNacionalView(navController, paddingValues)
    }
}

@Composable
fun ContentNacionalView(navController : NavController, paddingValues: PaddingValues){
    // Usamos un Column simple y centrado para la lista
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        // Nuevo Column para el contenido y el padding extra
        Column(
            modifier = Modifier
                .fillMaxSize()
                // <--- SOLUCIÓN: Aplicamos el padding extra aquí.
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            // 1. Tarjeta Ravens (AFC Norte)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- CAMBIO CLAVE: Ocupa 1/4 del espacio
                route = "GreenBaySplash",
                backColor = Color(0xFF004330),
                logoId = R.drawable.greenbay,
                division = "NFC NORTH",
                teamName = "Green Bay Packers"
            )

            // 2. Tarjeta Bills (AFC Este)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- Ocupa 1/4 del espacio
                route = "EaglesSplash",
                backColor = Color(0xFF014C54),
                logoId = R.drawable.eagles,
                division = "NFC EAST",
                teamName = "Philadelphia Eagles"
            )

            // 3. Tarjeta Texans (AFC Sur)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- Ocupa 1/4 del espacio
                route = "BucanerosSplash",
                backColor = Color(0xFFB22236),
                logoId = R.drawable.bucaneros,
                division = "NFC SOUTH",
                teamName = "Tampa Bay Buccaneers"
            )

            // 4. Tarjeta Chiefs (AFC Oeste)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- Ocupa 1/4 del espacio
                route = "49ersSplash",
                backColor = Color(0xFFA8956B),
                logoId = R.drawable.sanfrancisco,
                division = "NFC WEST",
                teamName = "San Francisco 49ers"
            )
        }
    }
}