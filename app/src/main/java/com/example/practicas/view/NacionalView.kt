package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.practicas.components.ActionButton
import com.example.practicas.components.MainButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NacionalView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("NFC") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue))
        },
        floatingActionButton = {
            ActionButton()
        }
    ){
        ContentNacionalView(navController)
    }
}

@Composable
fun ContentNacionalView(navController : NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextView("NFC")
        Space(espacio=20)
        MainButton(
            name = "Green Bay",
            backColor = Color.Green,
            color = Color.White
        ) {
            navController.navigate("GreenBay")
        }
        MainButton(
            name = "Eagles",
            backColor = Color.Green,
            color = Color.White
        ) {
            navController.navigate("Eagles")
        }
        MainButton(
            name = "Bucaneros",
            backColor = Color.Red,
            color = Color.White
        ) {
            navController.navigate("Bucaneros")
        }
        MainButton(
            name = "49ers",
            backColor = Color.Red,
            color = Color.White
        ) {
            navController.navigate("49ers")
        }
    }
}