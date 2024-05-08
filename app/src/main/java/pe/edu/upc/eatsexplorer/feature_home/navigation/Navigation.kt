package pe.edu.upc.eatsexplorer.feature_home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.eatsexplorer.feature_favorite.ui.FavoriteListScreen
import pe.edu.upc.eatsexplorer.feature_home.ui.HomeScreen
import pe.edu.upc.eatsexplorer.feature_restaurant.ui.RestaurantListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Routes.HomeScreen) {

        composable(Routes.HomeScreen) {
            HomeScreen(navController)
        }

        composable(Routes.RestaurantListScreen) {
            RestaurantListScreen(navController)
        }

        composable(Routes.FavoriteListScreen) {
            FavoriteListScreen(navController)
        }

    }
}