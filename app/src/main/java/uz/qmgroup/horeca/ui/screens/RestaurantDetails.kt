package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.restaurants.RestaurantDetailsScreen

@Destination
@Composable
fun RestaurantDetails(
    modifier: Modifier = Modifier,
    id: Long
) {
    RestaurantDetailsScreen(
        modifier = modifier,
        id = id
    )
}