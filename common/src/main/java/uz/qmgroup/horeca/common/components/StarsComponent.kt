package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StarsComponent(
    modifier: Modifier = Modifier,
    rating: Int
) {
    Row(modifier = modifier) {
        repeat(rating) {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "",
                tint = MaterialTheme.colors.primary
            )
        }
        repeat(5 - rating) {
            Icon(
                imageVector = Icons.Rounded.StarBorder,
                contentDescription = "",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}