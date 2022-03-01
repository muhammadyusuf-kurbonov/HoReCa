package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.RatingMark

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    subTitle: String,
    ratingStars: Int,
    rating: Float? = null,
    onClick: () -> Unit,
    additionalData: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(IntrinsicSize.Min)
        ) {

            Column(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier.padding(bottom = 4.dp)) {
                    Image(
                        painter = image,
                        contentDescription = title,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
                    )
                    if (rating != null)
                        RatingMark(rating = rating)
                }

                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                    Text(text = subTitle, style = MaterialTheme.typography.caption)
                }
            }

            Surface(
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    StarsComponent(rating = ratingStars, modifier = Modifier.align(Alignment.End))
                    additionalData()
                }
            }
        }
    }
}