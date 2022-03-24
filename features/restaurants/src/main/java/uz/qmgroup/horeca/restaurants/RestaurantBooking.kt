package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.BookingScreen
import uz.qmgroup.horeca.common.components.ButtonsGroup


@Composable
fun RestaurantBooking(
    modifier: Modifier = Modifier,
    restaurantId: Long,
    viewModel: RestaurantsViewModel = viewModel()
) {
    LaunchedEffect(key1 = restaurantId) {
        viewModel.loadItem(restaurantId)
    }
    val cafe = viewModel.item
    RestaurantsTheme {
        if (cafe != null) {
            BookingScreen(
                modifier = modifier,
                objectTitle = cafe.title,
                options = {
                    if (cafe.areas.isNotEmpty()) {
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                CompositionLocalProvider(
                                    LocalContentAlpha provides ContentAlpha.disabled
                                ) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = "Areas",
                                        style = MaterialTheme.typography.subtitle2,
                                        color = MaterialTheme.colors.onBackground,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                ButtonsGroup(
                                    modifier = Modifier.fillMaxWidth(),
                                    options = cafe.areas,
                                    optionsTextStyle = MaterialTheme.typography.body2,
                                    onOptionClick = {}
                                )
                            }
                        }
                    }

                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            CompositionLocalProvider(
                                LocalContentAlpha provides ContentAlpha.disabled
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Table type",
                                    style = MaterialTheme.typography.subtitle2,
                                    color = MaterialTheme.colors.onBackground,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            ButtonsGroup(
                                modifier = Modifier.fillMaxWidth(),
                                options = listOf(
                                    "Bir kishilik",
                                    "Ikki kishilik"
                                ),
                                onOptionClick = {}
                            )
                        }
                    }

                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            CompositionLocalProvider(
                                LocalContentAlpha provides ContentAlpha.disabled
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Date",
                                    style = MaterialTheme.typography.subtitle2,
                                    color = MaterialTheme.colors.onBackground,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(99.dp),
                                onClick = { /*TODO*/ }
                            ) {
                                Row(
                                    modifier = Modifier.padding(4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Event,
                                        contentDescription = ""
                                    )
                                    Text(
                                        text = "Select date",
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }

                        }
                    }
                }
            )
        }
    }
}