package uz.qmgroup.horeca.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import uz.qmgroup.horeca.cafes.CafeDetailsScreen

@Destination
@Composable
fun CafeDetails(
    modifier: Modifier = Modifier,
    id: Long
) {
    CafeDetailsScreen(
        modifier = modifier,
        id = id
    )
}