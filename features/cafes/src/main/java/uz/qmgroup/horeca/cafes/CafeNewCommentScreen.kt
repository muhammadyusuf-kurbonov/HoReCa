package uz.qmgroup.horeca.cafes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.comments.CommentsPage

@Composable
fun CafeNewCommentScreen(
    modifier: Modifier = Modifier,
    id: Long,
    cafesCommentViewModel: CafeCommentViewModel = viewModel(),
    cancel: () -> Unit
) {
    CafesTheme {
        CommentsPage(
            modifier = modifier,
            id = id,
            viewModel = cafesCommentViewModel,
            cancel = cancel
        )
    }
}