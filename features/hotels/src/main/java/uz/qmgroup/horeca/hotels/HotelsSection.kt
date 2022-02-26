package uz.qmgroup.horeca.hotels

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsSection
import uz.qmgroup.horeca.hotels.components.HotelCard

@Composable
fun HotelsSection(
    modifier: Modifier = Modifier,
    navigate: (Long) -> Unit,
    navigateToAll: () -> Unit,
    viewModel: HotelsViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadData()
    }

    HotelsTheme {
        ItemsSection(
            modifier = modifier,
            title = "Hotels",
            navigateToAll = navigateToAll,
            items = {
                items(viewModel.hotelsList) {
                    HotelCard(
                        hotel = it,
                        modifier = Modifier
                            .width(360.dp)
                            .clickable { navigate(it.id) }
                    )
                }
            })
    }
}