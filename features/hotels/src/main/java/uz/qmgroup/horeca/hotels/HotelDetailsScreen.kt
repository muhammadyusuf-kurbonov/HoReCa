package uz.qmgroup.horeca.hotels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.Pool
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import uz.qmgroup.horeca.common.components.DetailsScreen
import uz.qmgroup.horeca.common.models.SocialPage
import uz.qmgroup.horeca.hotels.components.FeatureIcon

@Composable
fun HotelDetailsScreen(
    modifier: Modifier = Modifier,
    id: Long,
    hotelsViewModel: HotelsViewModel = viewModel(),
    gotoBooking: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        hotelsViewModel.loadItem(id)
    }
    val item = hotelsViewModel.item
    if (item != null) {
        HotelsTheme {
            DetailsScreen(
                modifier = modifier,
                image = rememberImagePainter(data = item.imageUrl),
                title = item.title,
                subTitle = item.address,
                stars = item.stars,
                price = 1200,
                phone = item.phone,
                socialPages = listOf(
                    SocialPage.Instagram to "https://instagram.com/test",
                    SocialPage.Facebook to "https://facebook.com/test",
                    SocialPage.WebSite to "https://test.com",
                    SocialPage.Google to "https://google.com/?query=test",
                    SocialPage.Telegram to "https://t.me/test"
                ),
                features = {
                    Row(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        FeatureIcon(
                            modifier = Modifier.weight(1f)
                                .aspectRatio(1f),
                            icon = rememberVectorPainter(image = Icons.Rounded.Wifi),
                            enabled = item.wifi
                        )
                        FeatureIcon(
                            modifier = Modifier.weight(1f).aspectRatio(1f),
                            icon = rememberVectorPainter(image = Icons.Rounded.Restaurant),
                            enabled = item.restaurant
                        )
                        FeatureIcon(
                            modifier = Modifier.weight(1f).aspectRatio(1f),
                            icon = rememberVectorPainter(image = Icons.Rounded.FitnessCenter),
                            enabled = item.gym
                        )
                        FeatureIcon(
                            modifier = Modifier.weight(1f).aspectRatio(1f),
                            icon = rememberVectorPainter(image = Icons.Rounded.Pool),
                            enabled = item.pool
                        )
                    }
                },
                reviews = listOf(),
                gotoBooking = gotoBooking
            )
        }
    }
}