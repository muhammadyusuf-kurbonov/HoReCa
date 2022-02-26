package uz.qmgroup.horeca.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.qmgroup.horeca.cafes.CafesSection
import uz.qmgroup.horeca.hotels.HotelsSection
import uz.qmgroup.horeca.restaurants.RestaurantsSection
import uz.qmgroup.horeca.ui.screens.destinations.HotelsListDestination
import uz.qmgroup.horeca.ui.screens.destinations.RestaurantsListDestination

@Destination(start = true)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    LazyColumn(
        modifier = modifier.padding(16.dp, 0.dp, 16.dp, 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = uz.qmgroup.horeca.R.mipmap.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
            )
        }
        item {
            HotelsSection(
                navigate = {
//                navigator.navigate()
                },
                navigateToAll = {
                    navigator.navigate(HotelsListDestination)
                })
        }
        item {
            RestaurantsSection(navigateToAll = {
                navigator.navigate(RestaurantsListDestination)
            })
        }
        item {
            CafesSection(navigateToAll = {

            })
        }
    }
}