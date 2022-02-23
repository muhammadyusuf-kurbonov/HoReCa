package uz.qmgroup.horeca.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import uz.qmgroup.horeca.common.ItemCard
import uz.qmgroup.horeca.common.models.Hotel
import uz.qmgroup.horeca.features.R
import java.text.NumberFormat

@Composable
fun HotelCard(
    modifier: Modifier = Modifier,
    hotel: Hotel
) {
    val image = hotel.imageUrl.ifEmpty { R.mipmap.img_hilton }

    ItemCard(
        image = rememberImagePainter(data = image) {
            transformations(RoundedCornersTransformation(16f))
        },
        title = hotel.title,
        subTitle = hotel.city,
        modifier = modifier,
        rating = hotel.rating,
        additionalData = {

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.End
            ) {
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Row {
                        val ratingStars = hotel.stars
                        repeat(ratingStars) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        repeat(5 - ratingStars) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = hotel.address,
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End
                        )
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "",
                            modifier = Modifier.padding(4.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${hotel.distanceToIt} km",
                            style = MaterialTheme.typography.labelMedium,
                        )
                        Icon(
                            imageVector = Icons.Default.MailOutline,
                            contentDescription = "",
                            modifier = Modifier.padding(4.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                }

                Text(text = buildAnnotatedString {
                    withStyle(
                        MaterialTheme.typography.bodyMedium.toSpanStyle()
                    ) {
                        append("from ")
                    }
                    withStyle(
                        MaterialTheme.typography.titleLarge.toSpanStyle()
                            .copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                    ) {
                        append(NumberFormat.getCurrencyInstance().format(hotel.price))
                    }
                })
            }
        }
    )
}