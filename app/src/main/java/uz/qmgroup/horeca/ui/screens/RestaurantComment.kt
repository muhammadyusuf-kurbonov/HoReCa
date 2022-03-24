package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.destinations.HotelDetailsDestination
import uz.qmgroup.horeca.restaurants.RestaurantNewCommentScreen


@Destination
@Composable
fun RestaurantComment(
    modifier: Modifier = Modifier,
    id: Long,
    navigator: DestinationsNavigator
) {
    RestaurantNewCommentScreen(
        modifier = modifier,
        id = id,
        cancel = {
            navigator.navigate(HotelDetailsDestination(id))
        }
    )
}