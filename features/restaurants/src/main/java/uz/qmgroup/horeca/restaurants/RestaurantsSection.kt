package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.components.ItemsSection

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
    navigateToAll: () -> Unit,
) {
    RestaurantsTheme {
        ItemsSection(
            modifier = modifier,
            title = "Restaurants",
            navigateToAll = navigateToAll,
            items = {
                items(restaurants) {
                    RestaurantCard(
                        restaurant = it,
                        modifier = Modifier.width(360.dp)
                    )
                }
            })
    }
}
