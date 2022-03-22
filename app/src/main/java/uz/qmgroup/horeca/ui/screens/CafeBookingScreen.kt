package uz.qmgroup.horeca.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.cafes.CafeBooking

@Destination
@Composable
fun CafeBookingScreen(
    modifier: Modifier = Modifier,
    cafeId: Long
) {
    CafeBooking(
        modifier = modifier
            .fillMaxSize(),
        cafeId = cafeId
    )
}