package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.practicas.R
import kotlinx.coroutines.delay

@Composable
fun SanFranciscoSplash(navController: NavController){
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate("49ers"){
            popUpTo("49ers"){

            }
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id= R.drawable.sanfranback), // Tu imagen actual
            contentDescription = "Logo",
            // <--- MODIFICACIÓN CLAVE ABAJO
            modifier = Modifier.fillMaxSize(), // Asegura que el componente Image cubra el Box
            contentScale = ContentScale.Crop // <--- ESTO FUERZA A LA IMAGEN A LLENAR TODA EL ÁREA
        )
    }
}