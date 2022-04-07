package uz.qmgroup.horeca.hotels.screen.comment

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.comments.CommentsPage
import uz.qmgroup.horeca.hotels.HotelsTheme


@Composable
fun HotelNewCommentScreen(
    modifier: Modifier = Modifier,
    id: Long,
    hotelCommentsViewModel: HotelCommentsViewModel = viewModel(),
    cancel: () -> Unit
) {
    HotelsTheme {
        CommentsPage(
            modifier = modifier,
            id = id,
            viewModel = hotelCommentsViewModel,
            cancel = cancel
        )
    }
}