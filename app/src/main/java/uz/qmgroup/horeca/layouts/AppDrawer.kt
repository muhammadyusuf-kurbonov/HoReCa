package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.R

@Composable
private fun appMenu() = listOf<Pair<Painter, String>>(
    painterResource(id = R.drawable.ic_baseline_language_24) to "Tilni o'zgartirish",
    painterResource(id = R.drawable.ic_baseline_currency_exchange_24) to "Valyutani o'zgartirish",
    painterResource(id = R.drawable.ic_baseline_location_searching_24) to "Geopozitsiya",
    painterResource(id = R.drawable.ic_baseline_hotel_24) to "Hotels",
    painterResource(id = R.drawable.ic_baseline_restaurant_24) to "Restaurants",
    painterResource(id = R.drawable.ic_baseline_local_cafe_24) to "Cafes",
)

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
) {
    Surface(contentColor = MaterialTheme.colorScheme.primary) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(text = "HoReCa Uzbekistan", style = MaterialTheme.typography.titleLarge)

            val appMenu = appMenu()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(4.dp)){
                items(appMenu){
                    AppDrawerItem(
                        modifier = Modifier.fillMaxWidth(),
                        iconPainter = it.first,
                        label = it.second
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawerItem(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    label: String
) {
    Card(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = label,
                tint = LocalContentColor.current
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = LocalContentColor.current
            )
        }
    }
}