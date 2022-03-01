package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.hotels.HotelDetailsScreen

@Destination
@Composable
fun HotelDetails(
    modifier: Modifier = Modifier,
    id: Long
) {
    HotelDetailsScreen(
        modifier = modifier,
        id = id
    )
}