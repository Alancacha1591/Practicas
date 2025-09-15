package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicas.components.ActionButton
import com.example.practicas.components.TitleBar

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("HomeView") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Red))
            },
        floatingActionButton = {
            ActionButton()
            }
            ){
                ContentHomeView()
            }
}
        @Composable
        fun ContentHomeView(){

        }