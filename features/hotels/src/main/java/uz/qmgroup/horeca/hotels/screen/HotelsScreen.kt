package uz.qmgroup.horeca.hotels.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.features.hotels.R
import uz.qmgroup.horeca.hotels.HotelsViewModel
import uz.qmgroup.horeca.hotels.components.HotelCard
import uz.qmgroup.horeca.hotels.HotelsTheme

@Composable
fun HotelsScreen(
    modifier: Modifier = Modifier,
    hotelsViewModel: HotelsViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit){
        hotelsViewModel.loadData()
    }

    HotelsTheme {
        LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
            item {
                Text(
                    text = "Hotels",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Black
                )
            }
            item {
                Image(
                    painter = painterResource(id = R.mipmap.img_hilton),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                )
            }
            items(hotelsViewModel.hotelsList){
                HotelCard(
                    hotel = it,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}