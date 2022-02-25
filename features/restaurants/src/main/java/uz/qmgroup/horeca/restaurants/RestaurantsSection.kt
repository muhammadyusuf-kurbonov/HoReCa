package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

val restaurants = listOf(
    Restaurant(
        title = "Hilton",
        city = "Tashkent",
        rating = 3.5f,
        stars = 2,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        comment = "Hi. Best Restaurant",
        distanceToIt = 5L,
    ),
    Restaurant(
        title = "Big Hall",
        city = "Tashkent",
        rating = 3.5f,
        stars = 4,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
    ),
    Restaurant(
        title = "Big Hall",
        city = "Tashkent",
        rating = 5f,
        stars = 3,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
    )
)

@Composable
fun RestaurantsSection(
    modifier: Modifier = Modifier,
) {
    RestaurantsTheme {
        Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Restaurants",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "All",
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
                }
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(restaurants) {
                    RestaurantCard(
                        restaurant = it,
                        modifier = Modifier.
                        width(360.dp)
                    )
                }
            }
        }
    }
}
