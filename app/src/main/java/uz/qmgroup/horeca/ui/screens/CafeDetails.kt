package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.cafes.CafeDetailsScreen
import uz.qmgroup.horeca.destinations.CafeBookingScreenDestination

@Destination
@Composable
fun CafeDetails(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    id: Long
) {
    CafeDetailsScreen(
        modifier = modifier,
        id = id,
        gotoBooking = {
            navigator.navigate(CafeBookingScreenDestination(id))
        }
    )
}