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
fun AmericanaView(navController: NavController){
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
                        painter = painterResource(id = R.drawable.afc), // <-- Asumiendo que el logo de AFC está aquí
                        contentDescription = "AFC Logo",
                        modifier = Modifier.height(35.dp) // Ajusta el tamaño del logo en la barra
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    // Color Rojo NFL (usando el hexadecimal que definimos)
                    containerColor = Color(0xFFD0202C)
                )
            )
        },
    ){ paddingValues -> // <--- PASO CLAVE 1: Capturar el padding
        // PASO CLAVE 2: Pasar el padding a la función de contenido
        ContentAmericanaView(navController, paddingValues)
    }
}

@Composable
fun ContentAmericanaView(navController: NavController, paddingValues: PaddingValues){
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
                route = "RavensSplash",
                backColor = Color(0xFF23176C),
                logoId = R.drawable.ravens,
                division = "AFC NORTH",
                teamName = "Baltimore Ravens"
            )

            // 2. Tarjeta Bills (AFC Este)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- Ocupa 1/4 del espacio
                route = "BillsSplash",
                backColor = Color(0xFF025496),
                logoId = R.drawable.bills,
                division = "AFC EAST",
                teamName = "Buffalo Bills"
            )

            // 3. Tarjeta Texans (AFC Sur)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- Ocupa 1/4 del espacio
                route = "TexansSplash",
                backColor = Color(0xFF031F2F),
                logoId = R.drawable.texans,
                division = "AFC SOUTH",
                teamName = "Houston Texans"
            )

            // 4. Tarjeta Chiefs (AFC Oeste)
            TeamCard(
                navController = navController,
                modifier = Modifier.weight(1f), // <--- Ocupa 1/4 del espacio
                route = "ChiefsSplash",
                backColor = Color(0xFFD2122C),
                logoId = R.drawable.chiefs,
                division = "AFC WEST",
                teamName = "Kansas City Chiefs"
            )
        }
    }
}