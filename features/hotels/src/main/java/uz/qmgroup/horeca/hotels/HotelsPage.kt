package uz.qmgroup.horeca.hotels

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.features.hotels.R

@Composable
fun HotelsPage(
    modifier: Modifier = Modifier,
    nextPage: () -> Unit
) {
    HotelsTheme {
        Box(modifier = modifier) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "HOTELS",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
                Image(
                    painter = painterResource(id = R.drawable.hotel_booking_amico),
                    contentDescription = "hotels"
                )
                Text(
                    text = "Find rooms in hotel near well-known sights and set a maximum price",
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold
                )
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.disabled,
                    LocalContentColor provides MaterialTheme.colors.onBackground
                ) {
                    Text(
                        text = "Keep your hotel search within budget and easily compare hotels",
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = nextPage,
                    shape = RoundedCornerShape(99.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}
