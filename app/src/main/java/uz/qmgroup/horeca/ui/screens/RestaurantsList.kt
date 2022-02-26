package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.restaurants.RestaurantsScreen

@Destination
@Composable
fun RestaurantsList(
    modifier: Modifier = Modifier,
) {
    RestaurantsScreen(modifier = modifier)
}