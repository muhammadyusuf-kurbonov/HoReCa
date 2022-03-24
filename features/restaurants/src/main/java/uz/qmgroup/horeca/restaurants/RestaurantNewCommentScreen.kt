package uz.qmgroup.horeca.restaurants

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.comments.CommentsPage


@Composable
fun RestaurantNewCommentScreen(
    modifier: Modifier = Modifier,
    id: Long,
    restaurantCommentViewModel: RestaurantCommentViewModel = viewModel(),
    cancel: () -> Unit
) {
    RestaurantsTheme {
        CommentsPage(
            modifier = modifier,
            id = id,
            viewModel = restaurantCommentViewModel,
            cancel = cancel
        )
    }
}