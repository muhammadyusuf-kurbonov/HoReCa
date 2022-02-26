package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.restaurants.RestaurantsScreen
import uz.qmgroup.horeca.ui.screens.destinations.HomeScreenDestination

@Destination
@Composable
fun RestaurantsList(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    RestaurantsScreen(
        modifier = modifier,
        navigateToMain = { navigator.navigate(HomeScreenDestination) }
    )
}