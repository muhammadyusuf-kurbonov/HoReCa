package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClickableStarsComponent(
    modifier: Modifier = Modifier,
    rating: Int,
    onClick: (Int) -> Unit
) {
    Row(modifier = modifier) {
        repeat(rating) {
            IconButton(onClick = { onClick(it + 1) }) {
                Icon(
                    modifier = Modifier
                        .width(48.dp)
                        .aspectRatio(1f),
                    imageVector = Icons.Rounded.Star,
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary,
                )
            }
        }
        repeat(5 - rating) {
            IconButton(onClick = { onClick(rating + it + 1) }) {
                Icon(
                    modifier = Modifier
                        .width(48.dp)
                        .aspectRatio(1f),
                    imageVector = Icons.Rounded.StarBorder,
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}