package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.hotels.screen.HotelsScreen
import uz.qmgroup.horeca.ui.screens.destinations.HomeScreenDestination

@Destination
@Composable
fun HotelsList(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    HotelsScreen(
        modifier = modifier,
        navigateToMain = { navigator.navigate(HomeScreenDestination) }
    )
}