package uz.qmgroup.horeca.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.models.Hotel
import uz.qmgroup.horeca.features.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(16.dp, 0.dp, 16.dp, 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.mipmap.img_hilton),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Hotels",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "All",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
            }
        }
        item {
            HotelCard(
                modifier = Modifier.fillMaxWidth(), hotel = Hotel(
                    title = "Hilton",
                    city = "Tashkent",
                    rating = 3.5f,
                    stars = 2,
                    address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
                    price = 120f
                )
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Restaurants",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "All",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
            }
        }
        item {
            HotelCard(
                modifier = Modifier.fillMaxWidth(), hotel = Hotel(
                    title = "Seoul",
                    city = "Tashkent",
                    rating = 4f,
                    stars = 3,
                    address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
                    price = 50f
                )
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Cafes",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "All",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
            }
        }
        item {
            HotelCard(
                modifier = Modifier.fillMaxWidth(), hotel = Hotel(
                    title = "Evos",
                    city = "Tashkent",
                    rating = 4f,
                    stars = 3,
                    address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
                    price = 50f
                )
            )
        }
    }
}