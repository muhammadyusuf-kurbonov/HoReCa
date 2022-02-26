package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.cafes.CafesScreen
import uz.qmgroup.horeca.ui.screens.destinations.HomeScreenDestination

@Destination
@Composable
fun CafesList(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    CafesScreen(
        modifier = modifier,
        navigateToMain = { navigator.navigate(HomeScreenDestination) }
    )
}