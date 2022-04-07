package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.destinations.HotelDetailsDestination
import uz.qmgroup.horeca.hotels.screen.comment.HotelNewCommentScreen

@Destination
@Composable
fun HotelComment(
    modifier: Modifier = Modifier,
    id: Long,
    navigator: DestinationsNavigator
) {
    HotelNewCommentScreen(
        modifier = modifier,
        id = id,
        cancel = {
            navigator.navigate(HotelDetailsDestination(id))
        }
    )
}