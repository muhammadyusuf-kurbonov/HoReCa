package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.SearchResultsCard

@Composable
fun RestaurantsSearchResults(
    modifier: Modifier = Modifier,
    searchQuery: String,
    navigateToAll: () -> Unit,
    navigateToRestaurant: (Long) -> Unit,
    restaurantsViewModel: RestaurantsViewModel = viewModel()
) {
    RestaurantsTheme {
        SearchResultsCard(
            modifier = modifier,
            searchQuery = searchQuery,
            viewModel = restaurantsViewModel,
            title = "Restaurants",
            navigateToAll = navigateToAll,
            renderItem = {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navigateToRestaurant(it.id) }
                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(imageVector = Icons.Outlined.Restaurant, contentDescription = "", tint = MaterialTheme.colors.primary)
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(text = it.title, style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                            Text(text = it.city, style = MaterialTheme.typography.body2)
                        }
                    }
                }
            }
        )
    }
}