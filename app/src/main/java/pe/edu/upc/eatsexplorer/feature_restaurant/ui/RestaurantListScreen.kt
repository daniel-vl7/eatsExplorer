package pe.edu.upc.eatsexplorer.feature_restaurant.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.eatsexplorer.feature_home.navigation.Routes
import pe.edu.upc.eatsexplorer.feature_restaurant.data.repository.RestaurantRepository
import pe.edu.upc.eatsexplorer.feature_restaurant.domain.Restaurant
import pe.edu.upc.eatsexplorer.shared.ui.CustomButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
@Composable
fun RestaurantListScreen(navController: NavController,
                         restaurantRepository:RestaurantRepository = RestaurantRepository()) {
    val restaurants = remember {
        mutableStateOf(emptyList<Restaurant>())
    }
    restaurantRepository.getAll {
        restaurants.value = it
    }


    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            CustomButton(text = "Return", onClick = {
                navController.navigate(Routes.HomeScreen)
            } )
            Text(text ="Restaurants List")
        }
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(restaurants.value) { restaurant ->
                RestaurantItem(restaurant,
                    insert = {
                        restaurantRepository.insert(it)
                    }, delete = {
                        restaurantRepository.delete(it)
                    })
            }
        }
    }
}
@Composable
fun RestaurantItem(restaurant: Restaurant, insert: (Int) -> Unit, delete: (Int) -> Unit) {
    val isFavorite = remember {
        mutableStateOf(restaurant.isFavorite)
    }


    Card(modifier = Modifier.padding(4.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            RestaurantImage(restaurant.url)
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(3f), text = restaurant.name
            )
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {

                    isFavorite.value = !isFavorite.value
                    restaurant.isFavorite = isFavorite.value
                    if (isFavorite.value) {
                        insert(restaurant.id)
                    } else {
                        delete(restaurant.id)
                    }
                }) {
                Icon(
                    Icons.Filled.Favorite,
                    "Favorito",
                    tint = if (isFavorite.value) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Gray
                    }
                )
            }
        }
    }
}


@Composable
fun RestaurantImage(url: String) {
    GlideImage(modifier = Modifier.size(92.dp), imageModel = { url })
}