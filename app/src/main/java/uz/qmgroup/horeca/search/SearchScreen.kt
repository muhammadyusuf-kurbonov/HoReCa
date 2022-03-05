package uz.qmgroup.horeca.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.cafes.CafesSearchResults
import uz.qmgroup.horeca.destinations.*
import uz.qmgroup.horeca.hotels.HotelsSearchResult
import uz.qmgroup.horeca.restaurants.RestaurantsSearchResults
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@OptIn(ExperimentalFoundationApi::class)
@Destination
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = viewModel()
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        stickyHeader {
            Surface {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = viewModel.searchPattern,
                    onValueChange = viewModel::updateSearchPattern,
                    placeholder = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                    }
                )
            }
        }

        item {
            HotelsSearchResult(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                searchQuery = viewModel.searchPattern,
                navigateToAll = {
                    navigator.navigate(HotelsListDestination)
                },
                navigateToHotel = {
                    navigator.navigate(HotelDetailsDestination(it))
                }
            )
            HoReCaTheme {}
        }

        item {
            RestaurantsSearchResults(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                searchQuery = viewModel.searchPattern,
                navigateToAll = {
                    navigator.navigate(RestaurantsListDestination)
                },
                navigateToRestaurant = {
                    navigator.navigate(RestaurantDetailsDestination(it))
                }
            )
            HoReCaTheme {}
        }

        item {
            CafesSearchResults(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                searchQuery = viewModel.searchPattern,
                navigateToAll = {
                    navigator.navigate(CafesListDestination)
                },
                navigateToCafe = {
                    navigator.navigate(CafeDetailsDestination(it))
                }
            )
            HoReCaTheme {}
        }
    }
}