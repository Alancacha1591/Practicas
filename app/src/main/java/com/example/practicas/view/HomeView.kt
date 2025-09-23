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
fun HomeView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("NFL") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Black))
            },
        floatingActionButton = {
            ActionButton()
        }
    ){
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController : NavController){
    val id = 1;
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextView("Elige Conferencia")
        Space(espacio=20)
        MainButton(
            name = "AFC View",
            backColor = Color.Red,
            color = Color.White
        ) {
            //navController.navigate("Detail/${id}")
            navController.navigate("AFC")
        }
        MainButton(
            name = "NFC View",
            backColor = Color.Blue,
            color = Color.White
        ) {
            //navController.navigate("Detail/${id}")
            navController.navigate("NFC")
        }
    }

}