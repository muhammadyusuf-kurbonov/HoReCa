package uz.qmgroup.horeca.hotels

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Hotel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.SearchResultsCard

@Composable
fun HotelsSearchResult(
    modifier: Modifier = Modifier,
    searchQuery: String,
    navigateToAll: () -> Unit,
    navigateToHotel: (Long) -> Unit,
    hotelsViewModel: HotelsViewModel = viewModel()
) {
    HotelsTheme {
        SearchResultsCard(
            modifier = modifier,
            searchQuery = searchQuery,
            viewModel = hotelsViewModel,
            title = "Hotels",
            navigateToAll = navigateToAll,
            renderItem = {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navigateToHotel(it.id) }
                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(imageVector = Icons.Outlined.Hotel, contentDescription = "", tint = MaterialTheme.colors.primary)
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