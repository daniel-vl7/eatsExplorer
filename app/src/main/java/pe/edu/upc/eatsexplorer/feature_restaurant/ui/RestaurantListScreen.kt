package pe.edu.upc.eatsexplorer.feature_restaurant.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import pe.edu.upc.eatsexplorer.feature_home.navigation.Routes
import pe.edu.upc.eatsexplorer.shared.ui.CustomButton

@Composable
fun RestaurantListScreen(navController: NavController) {
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(text = "Return", onClick = {
                navController.navigate(Routes.HomeScreen)
            } )
            Text(text ="Restaurants List")
        }
    }
}