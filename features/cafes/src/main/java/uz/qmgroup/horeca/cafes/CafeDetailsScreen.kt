package uz.qmgroup.horeca.cafes

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
import uz.qmgroup.horeca.common.models.Review
import uz.qmgroup.horeca.common.models.SocialPage

@Composable
fun CafeDetailsScreen(
    modifier: Modifier = Modifier,
    id: Long,
    cafesViewModel: CafesViewModel = viewModel(),
    gotoBooking: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        cafesViewModel.loadItem(id)
    }
    val item = cafesViewModel.item
    if (item != null) {
        CafesTheme {
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
                reviews = listOf(
                    Review(
                        "cafe",
                        0,
                        "Sebastian",
                        "Hallo. Very good place. I want again! And loooooooooooong tooAnd loooooooooooong tooAnd loooooooooooong tooAnd loooooooooooong tooAnd loooooooooooong tooAnd loooooooooooong too"
                    ),
                    Review(
                        "cafe",
                        0,
                        "Sebastian",
                        "Hallo. Very good place. I want again!"
                    ),
                    Review(
                        "cafe",
                        0,
                        "Sebastian",
                        "Hallo. Very good place. I want again!"
                    ),
                ),
                gotoBooking = gotoBooking
            )
        }
    }
}