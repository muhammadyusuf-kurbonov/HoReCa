package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.hotels.screen.HotelsScreen

@Destination
@Composable
fun HotelsList(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    HotelsScreen(modifier = modifier)
}