package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicas.view.DetailsView
import com.example.practicas.view.HomeView
import com.example.practicas.view.SplashScreen

@Composable
fun NavManager(){
    val navController: NavHostController = rememberNavController()

    NavHost(navController=navController,
        startDestination = "Splash"){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}", arguments =
            listOf(navArgument("id")
            {type = NavType.IntType})){
            val id:Int = it.arguments?.getInt("id")?:0
            DetailsView(navController,id)
        }
        composable("Splash"){
            SplashScreen(navController)
        }
    }
}