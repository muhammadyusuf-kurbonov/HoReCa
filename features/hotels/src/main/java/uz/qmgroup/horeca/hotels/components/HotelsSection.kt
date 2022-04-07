package uz.qmgroup.horeca.hotels.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsSection
import uz.qmgroup.horeca.hotels.HotelsTheme
import uz.qmgroup.horeca.hotels.HotelsViewModel

@Composable
fun HotelsSection(
    modifier: Modifier = Modifier,
    navigateToAll: () -> Unit,
    navigateToDetails: (id: Long) -> Unit,
    viewModel: HotelsViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadPreviewData()
    }

    HotelsTheme {
        ItemsSection(
            modifier = modifier,
            title = "Hotels",
            navigateToAll = navigateToAll,
            items = {
                items(viewModel.itemsList) {
                    HotelCard(
                        hotel = it,
                        modifier = Modifier
                            .width(360.dp),
                        onCLick = { navigateToDetails(it.id) }
                    )
                }
            })
    }
}
