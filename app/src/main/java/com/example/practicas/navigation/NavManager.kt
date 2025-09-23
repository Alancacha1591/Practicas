package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicas.view.AmericanaView
import com.example.practicas.view.DetailsView
import com.example.practicas.view.HomeView
import com.example.practicas.view.NacionalView
import com.example.practicas.view.SplashScreen

@Composable
fun NavManager(){
    val navController: NavHostController = rememberNavController()

    NavHost(navController=navController, startDestination = "Splash"){
        //Splash
        composable("Splash"){ SplashScreen(navController) }
        //Home
        composable("Home"){ HomeView(navController) }
        //Conferencias
        composable("AFC"){ AmericanaView(navController) }
        composable("NFC"){ NacionalView(navController) }
        //----------------------------------------------------------------------------------------------
        //AFC Norte

        //AFC Este

        //AFC Sur

        //AFC Oeste

        //----------------------------------------------------------------------------------------------
        //NFC Norte

        //NFC Este

        //NFC Sur

        //NFC Oeste
        


        composable("Detail/{id}", arguments =
            listOf(navArgument("id")
            {type = NavType.IntType})){
            val id:Int = it.arguments?.getInt("id")?:0
            DetailsView(navController,id)
        }
    }
}