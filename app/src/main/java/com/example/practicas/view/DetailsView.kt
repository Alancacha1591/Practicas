package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.practicas.components.MainButton
import com.example.practicas.components.MainIconButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsView(navController: NavController,id:Int){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("DetailsView") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
            )
        ,navigationIcon = {
            MainIconButton(icon = Icons.Default.ArrowBack){
                navController.popBackStack()
            }
        }
        )
    }
    ){
        ContentDetailView(navController,id)
    }
}


@Composable
fun ContentDetailView(navController: NavController,id:Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextView(texto="Detail View")
        Space(espacio = 20)
        TextView (texto=id.toString())
        MainButton(
            name="Return Home",
            backColor = Color.Blue,
            color = Color.White
        ) {
            navController.navigate("Home")
        }
    }
}