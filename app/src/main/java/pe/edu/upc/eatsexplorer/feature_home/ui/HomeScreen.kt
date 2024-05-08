package pe.edu.upc.eatsexplorer.feature_home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.eatsexplorer.feature_home.navigation.Routes
import pe.edu.upc.eatsexplorer.shared.ui.CustomButton

@Composable
fun HomeScreen(navController: NavController){
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            //HeroImage(url="")
            Text(text = "Welcome to Eats Explorer")
            CustomButton(text = "Restaurants", onClick = {
                navController.navigate(Routes.RestaurantListScreen)
            } )
            CustomButton(text = "Favorite", onClick = {
                navController.navigate(Routes.FavoriteListScreen)
            } )
        }
    }
}

@Composable
fun HeroImage(url:String){
    GlideImage(modifier = Modifier.size(width = 350.dp, height = 170.dp),imageModel = { url })
}