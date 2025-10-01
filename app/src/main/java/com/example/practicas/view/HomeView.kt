package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.R
import com.example.practicas.components.MainButtonLogo
import com.example.practicas.components.Space
import com.example.practicas.components.TextViewHV
import com.example.practicas.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("NFL") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Black))
            },

    ){
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.nfl_back),
                contentDescription = "Fondo NFL",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
            ContentHomeView(navController)
        }
    }
}

@Composable
fun ContentHomeView(navController : NavController){
    val id = 1;
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.85f)) // <--- Fondo NEGRO 50% transparente
                .padding(vertical = 8.dp), // Espacio vertical dentro del Box
            contentAlignment = Alignment.Center // Asegura que el contenido del Box esté centrado
        ) {
            TextViewHV(
                texto = "ELIGE TU CONFERENCIA",
            )
        }
        Space(40)

        MainButtonLogo(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            backColor = Color(0xFFD0202C),
            color = Color.White,
            onClick = { navController.navigate("AFC") }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.afc),
                    contentDescription = "AFC Logo",
                    modifier = Modifier.height(120.dp)
                )
                Space(30)
                Text(
                    text = "CONFERENCIA AMERICANA (AFC)",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }

        MainButtonLogo(
            modifier = Modifier
                .fillMaxWidth(),
            backColor = Color(0xFF103C65),
            color = Color.White,
            onClick = { navController.navigate("NFC") }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.nfc),
                    contentDescription = "NFC Logo",
                    modifier = Modifier.height(120.dp)
                )
                Space(30)
                Text(
                    text = "CONFERENCIA NACIONAL (NFC)",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }

    }
}