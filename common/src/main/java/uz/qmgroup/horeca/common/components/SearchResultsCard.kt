package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.BaseViewModel

@Composable
fun <E> SearchResultsCard(
    modifier: Modifier = Modifier,
    searchQuery: String,
    viewModel: BaseViewModel<E>,
    title: String,
    navigateToAll: () -> Unit,
    renderItem: @Composable (item: E) -> Unit
) {
    LaunchedEffect(key1 = searchQuery) {
        viewModel.searchData(searchQuery)
    }

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { navigateToAll() }) {
                Text(
                    text = "All",
                    style = MaterialTheme.typography.subtitle1,
                )
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
            }
        }

        if (viewModel.itemsList.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    viewModel.itemsList.forEach {
                        renderItem(it)
                    }
                }
            }
        }
    }
}