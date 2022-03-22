package uz.qmgroup.horeca.hotels.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.Pool
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import uz.qmgroup.horeca.common.components.ItemCard
import uz.qmgroup.horeca.features.hotels.R
import uz.qmgroup.horeca.hotels.Hotel
import java.text.NumberFormat

@Composable
fun HotelCard(
    modifier: Modifier = Modifier,
    hotel: Hotel,
    onCLick: () -> Unit = {}
) {
    val image = hotel.imageUrl.ifEmpty { R.mipmap.img_hilton }

    ItemCard(
        image = rememberImagePainter(data = image) {
            transformations(RoundedCornersTransformation(16f))
        },
        title = hotel.title,
        subTitle = hotel.city,
        modifier = modifier.padding(8.dp),
        rating = hotel.rating,
        ratingStars = hotel.stars,
        onClick = onCLick,
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
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = hotel.address,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End
                        )
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "",
                            modifier = Modifier.padding(4.dp),
                            tint = MaterialTheme.colors.primary
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${hotel.distanceToIt} km",
                            style = MaterialTheme.typography.body2,
                        )
                        Icon(
                            imageVector = Icons.Outlined.Explore,
                            contentDescription = "",
                            modifier = Modifier.padding(4.dp),
                            tint = MaterialTheme.colors.primary
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        FeatureIcon(
                            icon = rememberVectorPainter(image = Icons.Rounded.Wifi),
                            enabled = hotel.wifi
                        )
                        FeatureIcon(
                            icon = rememberVectorPainter(image = Icons.Rounded.Restaurant),
                            enabled = hotel.restaurant
                        )
                        FeatureIcon(
                            icon = rememberVectorPainter(image = Icons.Rounded.FitnessCenter),
                            enabled = hotel.gym
                        )
                        FeatureIcon(
                            icon = rememberVectorPainter(image = Icons.Rounded.Pool),
                            enabled = hotel.pool
                        )
                    }

                }

                Text(text = buildAnnotatedString {
                    withStyle(
                        MaterialTheme.typography.body2.toSpanStyle()
                    ) {
                        append("from ")
                    }
                    withStyle(
                        MaterialTheme.typography.h6.toSpanStyle()
                            .copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.primary
                            )
                    ) {
                        append(NumberFormat.getCurrencyInstance().format(hotel.price))
                    }
                })
            }
        }
    )
}