package uz.qmgroup.horeca.common.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.icons.filled.Tune
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import uz.qmgroup.horeca.common.BaseViewModel


@Composable
fun <E> ItemsScreen(
    modifier: Modifier = Modifier,
    title: String,
    mainImage: Painter,
    viewModel: BaseViewModel<E>,
    navigateBack: () -> Unit,
    dialog: @Composable () -> Unit,
    renderItem: @Composable (item: E) -> Unit
) {
    var showSortDialog by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.loadPreviewData()
    }

    BackHandler {
        navigateBack()
    }

    if (showSortDialog)
        Dialog(onDismissRequest = { showSortDialog = false }) {
            dialog()
        }

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        item {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Black
            )
        }
        item {
            Image(
                painter = mainImage,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
            )
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Button(
                        onClick = { showSortDialog = true },
                        shape = RoundedCornerShape(topStart = 99.dp, bottomStart = 99.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Sort, contentDescription = "Sort")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "sort", style = MaterialTheme.typography.button)
                    }
                    Button(onClick = { /*TODO*/ }, shape = RectangleShape) {
                        Icon(imageVector = Icons.Default.Tune, contentDescription = "Filter")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "filter", style = MaterialTheme.typography.button)
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(topEnd = 99.dp, bottomEnd = 99.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Explore, contentDescription = "Map")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(text = "map", style = MaterialTheme.typography.button)
                    }
                }
            }
        }
        items(viewModel.itemsList) {
            renderItem(it)
        }
    }
}