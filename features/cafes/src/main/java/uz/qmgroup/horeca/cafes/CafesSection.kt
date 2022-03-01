package uz.qmgroup.horeca.cafes

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsSection

@Composable
fun CafesSection(
    modifier: Modifier = Modifier,
    navigateToAll: () -> Unit,
    navigateToDetails: (Long) -> Unit,
    cafesViewModel: CafesViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit){
        cafesViewModel.loadPreviewData()
    }

    CafesTheme {
        ItemsSection(
            modifier = modifier,
            title = "Cafes",
            navigateToAll = navigateToAll,
            items = {
                items(cafesViewModel.itemsList) {
                    CafeCard(
                        cafe = it,
                        modifier = Modifier.width(360.dp),
                        onClick = { navigateToDetails(it.id) }
                    )
                }
            })
    }
}
