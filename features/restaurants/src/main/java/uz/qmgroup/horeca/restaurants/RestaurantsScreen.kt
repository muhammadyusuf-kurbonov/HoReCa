package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsScreen
import uz.qmgroup.horeca.features.restaurants.R

@Composable
fun RestaurantsScreen(
    modifier: Modifier = Modifier,
    restaurantsViewModel: RestaurantsViewModel = viewModel(),
    navigateToDetails: (Long) -> Unit,
    navigateToMain: () -> Unit
) {
    RestaurantsTheme {
        ItemsScreen(
            modifier = modifier,
            title = "Restaurants",
            mainImage = painterResource(id = R.drawable.restaurant),
            viewModel = restaurantsViewModel,
            navigateBack = navigateToMain,
            dialog = {
                SortDialog(applyFilter = {})
            },
            renderItem = {
                RestaurantCard(
                    restaurant = it,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navigateToDetails(it.id)
                    }
                )
            }
        )
    }
}