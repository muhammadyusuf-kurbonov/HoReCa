package uz.qmgroup.horeca.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.elevatedCardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    subTitle: String,
    rating: Float? = null,
    additionalData: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = elevatedCardElevation(defaultElevation = 8.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ) {
        Row(modifier = Modifier
            .padding(16.dp)
            .height(IntrinsicSize.Min)) {
            Column(modifier = Modifier.weight(1f)) {
                Box {
                    Image(
                        painter = image,
                        contentDescription = title,
                        modifier = Modifier
                            .aspectRatio(1f)
                    )
                    if (rating != null)
                        RatingMark(rating = rating)
                }

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(text = subTitle, style = MaterialTheme.typography.labelLarge)
            }
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    additionalData()
                }
            }
        }
    }
}