package uz.qmgroup.horeca.hotels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.BookingScreen
import uz.qmgroup.horeca.common.components.ButtonsGroup


@Composable
fun HotelBooking(
    modifier: Modifier = Modifier,
    hotelId: Long,
    viewModel: HotelsViewModel = viewModel()
) {
    LaunchedEffect(key1 = hotelId) {
        viewModel.loadItem(hotelId)
    }
    val cafe = viewModel.item
    HotelsTheme {
        if (cafe != null) {
            BookingScreen(
                modifier = modifier,
                objectTitle = cafe.title,
                options = {
                    if (cafe.tariffs.isNotEmpty()) {
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                CompositionLocalProvider(
                                    LocalContentAlpha provides ContentAlpha.disabled
                                ) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = "Tariffs",
                                        style = MaterialTheme.typography.subtitle2,
                                        color = MaterialTheme.colors.onBackground,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                ButtonsGroup(
                                    modifier = Modifier.fillMaxWidth(),
                                    options = cafe.tariffs,
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
                                    text = "Kravat",
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

                            ButtonsGroup(
                                modifier = Modifier.fillMaxWidth(),
                                options = listOf("Arrive date", "Leave date"),
                                icons = listOf(Icons.Default.Event, Icons.Default.Event),
                                onOptionClick = {

                                })
                        }
                    }
                }
            )
        }
    }
}