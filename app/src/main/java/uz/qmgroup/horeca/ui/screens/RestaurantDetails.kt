package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.destinations.RestaurantBookingScreenDestination
import uz.qmgroup.horeca.restaurants.RestaurantDetailsScreen

@Destination
@Composable
fun RestaurantDetails(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    id: Long,
) {
    RestaurantDetailsScreen(
        modifier = modifier,
        id = id,
        gotoBooking = {
            navigator.navigate(RestaurantBookingScreenDestination(id))
        }
    )
}