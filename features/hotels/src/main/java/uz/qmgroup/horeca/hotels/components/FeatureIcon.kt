package uz.qmgroup.horeca.hotels.components

import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun FeatureIcon(
    modifier: Modifier = Modifier,
    icon: Painter,
    enabled: Boolean,
) {
    CompositionLocalProvider(LocalContentAlpha provides
            if (enabled)
                ContentAlpha.high
            else
                ContentAlpha.disabled
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            modifier = modifier,
            tint = if (enabled) MaterialTheme.colors.primary else Color.Gray
        )
    }
}