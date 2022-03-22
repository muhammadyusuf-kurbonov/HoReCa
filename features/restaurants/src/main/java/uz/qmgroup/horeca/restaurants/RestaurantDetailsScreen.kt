package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import uz.qmgroup.horeca.common.components.DetailsScreen
import uz.qmgroup.horeca.common.models.SocialPage

@Composable
fun RestaurantDetailsScreen(
    modifier: Modifier = Modifier,
    id: Long,
    restaurantsViewModel: RestaurantsViewModel = viewModel(),
    gotoBooking: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        restaurantsViewModel.loadItem(id)
    }
    val item = restaurantsViewModel.item
    if (item != null) {
        RestaurantsTheme {
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
                    OutlinedButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(.5f)
                            .padding(16.dp, 32.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "MENU",
                            style = MaterialTheme.typography.h4,
                        )
                    }
                },
                comments = listOf(),
                gotoBooking = gotoBooking,
                gotoComments = {}
            )
        }
    }
}