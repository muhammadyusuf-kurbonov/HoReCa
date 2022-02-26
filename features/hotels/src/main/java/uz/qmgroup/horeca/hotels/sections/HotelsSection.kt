package uz.qmgroup.horeca.hotels.sections

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
import uz.qmgroup.horeca.hotels.Hotel
import uz.qmgroup.horeca.hotels.components.HotelCard


val hotels = listOf(
    Hotel(
        title = "Hilton",
        city = "Tashkent",
        rating = 3.5f,
        stars = 2,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        price = 120f,
        wifi = true
    ),
    Hotel(
        title = "Miras",
        city = "Tashkent",
        rating = 3.5f,
        stars = 4,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        price = 120f,
        wifi = true,
        restaurant = false,
        pool = true
    ),
    Hotel(
        title = "Big Hall",
        city = "Tashkent",
        rating = 5f,
        stars = 3,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        price = 120f,
        wifi = false,
        restaurant = true,
        gym = true
    )
)

@Composable
fun HotelsSection(
    modifier: Modifier = Modifier,
) {
    HotelsTheme {
        Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Hotels",
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
                items(hotels){
                    HotelCard(
                        hotel = it,
                        modifier = Modifier.
                            width(360.dp)
                    )
                }
            }
        }
    }
}
