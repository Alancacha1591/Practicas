package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicas.view.AmericanaView
import com.example.practicas.view.BillsView
import com.example.practicas.view.BucanerosView
import com.example.practicas.view.ChiefsView
import com.example.practicas.view.EaglesView
import com.example.practicas.view.GreenBayView
import com.example.practicas.view.HomeView
import com.example.practicas.view.NacionalView
import com.example.practicas.view.RavensView
import com.example.practicas.view.SanFranciscoView
import com.example.practicas.view.SplashScreen
import com.example.practicas.view.TexansView

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
        //AFC Norte - Ravens
        composable("Ravens"){ RavensView(navController) }
        //AFC Este - Bills
        composable("Bills"){ BillsView(navController) }
        //AFC Sur - Texans
        composable("Texans"){ TexansView(navController) }
        //AFC Oeste - Chiefs
        composable("Chiefs"){ ChiefsView(navController) }
        //----------------------------------------------------------------------------------------------
        //NFC Norte - Green Bay
        composable("GreenBay"){ GreenBayView(navController) }
        //NFC Este - Eagles
        composable("Eagles"){ EaglesView(navController) }
        //NFC Sur - Bucaneros
        composable("Bucaneros"){ BucanerosView(navController) }
        //NFC Oeste - 49ers
        composable("49ers"){ SanFranciscoView(navController) }


        /*composable("Detail/{id}", arguments =
            listOf(navArgument("id")
            {type = NavType.IntType})){
            val id:Int = it.arguments?.getInt("id")?:0
            DetailsView(navController,id)
        }*/
    }
}