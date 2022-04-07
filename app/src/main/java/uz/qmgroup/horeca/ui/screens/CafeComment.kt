package uz.qmgroup.horeca.ui.screens.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.cafes.screen.comment.CafeNewCommentScreen
import uz.qmgroup.horeca.destinations.CafeDetailsDestination

@Destination
@Composable
fun CafeComment(
    modifier: Modifier = Modifier,
    id: Long,
    navigator: DestinationsNavigator
) {
    CafeNewCommentScreen(
        modifier = modifier,
        id = id,
        cancel = {
            navigator.navigate(CafeDetailsDestination(id))
        }
    )
}