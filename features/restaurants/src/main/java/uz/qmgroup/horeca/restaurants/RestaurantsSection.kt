package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsSection

@Composable
fun RestaurantsSection(
    modifier: Modifier = Modifier,
    navigateToAll: () -> Unit,
    navigateToDetails: (Long) -> Unit,
    restaurantsViewModel: RestaurantsViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit){
        restaurantsViewModel.loadPreviewData()
    }

    RestaurantsTheme {
        ItemsSection(
            modifier = modifier,
            title = "Restaurants",
            navigateToAll = navigateToAll,
            items = {
                items(restaurantsViewModel.itemsList) {
                    RestaurantCard(
                        restaurant = it,
                        modifier = Modifier.width(360.dp),
                        onClick = { navigateToDetails(it.id) }
                    )
                }
            })
    }
}
