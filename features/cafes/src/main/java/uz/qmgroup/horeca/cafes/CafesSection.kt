package uz.qmgroup.horeca.cafes

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.components.ItemsSection

val cafes = listOf(
    Cafe(
        title = "Hilton",
        city = "Tashkent",
        rating = 3.5f,
        stars = 2,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        comment = "Hi. Best Restaurant",
        distanceToIt = 5L,
    ),
    Cafe(
        title = "Big Hall",
        city = "Tashkent",
        rating = 3.5f,
        stars = 4,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
    ),
    Cafe(
        title = "Big Hall",
        city = "Tashkent",
        rating = 5f,
        stars = 3,
        address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
    )
)

@Composable
fun CafesSection(
    modifier: Modifier = Modifier,
    navigateToAll: () -> Unit,
) {
    CafesTheme {
        ItemsSection(
            modifier = modifier,
            title = "Cafes",
            navigateToAll = navigateToAll,
            items = {
                items(cafes) {
                    CafeCard(
                        cafe = it,
                        modifier = Modifier.width(360.dp)
                    )
                }
            })
    }
}
