package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.BaseViewModel


@Composable
fun <E> ItemsScreen(
    modifier: Modifier = Modifier,
    title: String,
    mainImage: Painter,
    hotelsViewModel: BaseViewModel<E>,
    renderItem: @Composable (item: E) -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        hotelsViewModel.loadPreviewData()
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
        items(hotelsViewModel.itemsList) {
            renderItem(it)
        }
    }
}