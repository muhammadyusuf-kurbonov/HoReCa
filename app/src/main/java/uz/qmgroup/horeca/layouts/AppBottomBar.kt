package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    currentPage: String,
    navigate: (String) -> Unit
) {
    BottomNavigation(modifier = modifier, backgroundColor = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                AppBottomBarIcon(
                    modifier = Modifier.clickable { navigate("hotels") },
                    selected = currentPage == "hotels",
                    shortText = "Ho",
                    expandedText = "Hotels",
                    color = Color(0xFF22A6F0)
                )
                AppBottomBarIcon(
                    modifier = Modifier.clickable { navigate("restaurants") },
                    selected = currentPage == "restaurants",
                    shortText = "Re",
                    expandedText = "Restaurants",
                    color = Color(0xFFF05A22)
                )
                AppBottomBarIcon(
                    modifier = Modifier.clickable { navigate("cafes") },
                    selected = currentPage == "cafes",
                    shortText = "Ca",
                    expandedText = "Cafes",
                    color = Color(0xFF22F0A6)
                )
            }
        }
    }
}