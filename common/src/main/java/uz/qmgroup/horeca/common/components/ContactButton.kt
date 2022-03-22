package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ContactButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    action: () -> Unit
) {
    Card(
        modifier = modifier
            .aspectRatio(1f),
        shape = CircleShape,
        elevation = 16.dp
    ) {
        IconButton(onClick = action) {
            Icon(imageVector = icon, contentDescription = "", tint = MaterialTheme.colors.primary)
        }
    }
}