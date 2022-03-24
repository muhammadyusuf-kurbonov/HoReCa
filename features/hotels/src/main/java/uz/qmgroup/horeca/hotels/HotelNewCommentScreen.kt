package uz.qmgroup.horeca.hotels

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.comments.CommentsPage


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