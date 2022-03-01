package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.destinations.*

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    currentPage: TypedDestination<*>?,
    navigate: (DirectionDestination) -> Unit
) {
    BottomNavigation(modifier = modifier, backgroundColor = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.padding(top = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                AppBottomBarIcon(
                    modifier = Modifier.clickable { navigate(HotelsListDestination) },
                    selected = currentPage == HotelsListDestination,
                    shortText = "Ho",
                    expandedText = "Hotels",
                    color = Color(0xFF22A6F0)
                )
                AppBottomBarIcon(
                    modifier = Modifier.clickable { navigate(RestaurantsListDestination) },
                    selected = currentPage == RestaurantsListDestination,
                    shortText = "Re",
                    expandedText = "Restaurants",
                    color = Color(0xFFF05A22)
                )
                AppBottomBarIcon(
                    modifier = Modifier.clickable { navigate(CafesListDestination) },
                    selected = currentPage == CafesListDestination,
                    shortText = "Ca",
                    expandedText = "Cafes",
                    color = Color(0xFF22F0A6)
                )
            }
        }
    }
}