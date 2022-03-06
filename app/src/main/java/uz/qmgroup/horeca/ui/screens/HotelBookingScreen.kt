package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.hotels.HotelBooking

@Destination
@Composable
fun HomeBookingScreen(
    modifier: Modifier = Modifier,
    hotelId: Long
) {
    HotelBooking(
        modifier = modifier,
        hotelId = hotelId
    )
}