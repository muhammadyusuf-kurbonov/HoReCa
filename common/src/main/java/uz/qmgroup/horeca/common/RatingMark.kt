package uz.qmgroup.horeca.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun RatingMark(
    modifier: Modifier = Modifier,
    rating: Float,
) {
    Box(
        modifier = modifier
            .padding(16.dp, 0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_bookmark_24),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier.matchParentSize()
        )
        Row(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "", modifier = Modifier.height(16.dp))
            Text(
                text = DecimalFormat("0.0").format(rating),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}