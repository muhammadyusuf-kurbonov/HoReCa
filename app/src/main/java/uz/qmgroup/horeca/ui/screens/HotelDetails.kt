package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.destinations.HomeBookingScreenDestination
import uz.qmgroup.horeca.hotels.HotelDetailsScreen

@Destination
@Composable
fun HotelDetails(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    id: Long
) {
    HotelDetailsScreen(
        modifier = modifier,
        id = id,
        gotoBooking = {
            navigator.navigate(HomeBookingScreenDestination(id))
        }
    )
}