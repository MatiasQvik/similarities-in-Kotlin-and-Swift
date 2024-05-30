package fi.qvik.kotlinexample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationView() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "contentView",
    ) {
        composable( "contentView") {
            ContentView {
                navController.navigate("secondView/$it")
            }
        }
        composable( "secondView/{name}") {
            SecondView(it.arguments?.getString("name")!!,
                ) {
                navController.navigateUp()
            }
        }


    }

}