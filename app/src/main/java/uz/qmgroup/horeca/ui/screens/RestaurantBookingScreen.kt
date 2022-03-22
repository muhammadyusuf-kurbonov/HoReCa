package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.restaurants.RestaurantBooking

@Destination
@Composable
fun RestaurantBookingScreen(
    modifier: Modifier = Modifier,
    hotelId: Long
) {
    RestaurantBooking(
        modifier = modifier,
        restaurantId = hotelId
    )
}