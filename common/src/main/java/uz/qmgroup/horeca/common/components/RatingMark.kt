package uz.qmgroup.horeca.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun RatingMark(
    modifier: Modifier = Modifier,
    rating: Float,
) {
    Box(
        modifier = modifier
            .offset(y = (-2).dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_bookmark_24),
            contentDescription = "",
            tint = MaterialTheme.colors.background,
            modifier = Modifier.matchParentSize()
        )
        Row(
            modifier = Modifier.align(Alignment.TopCenter)
                .padding(16.dp, 8.dp, 16.dp, 16.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "", modifier = Modifier.height(12.dp))
            Text(
                text = DecimalFormat("0.0").format(rating),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Black
            )
        }
    }
}