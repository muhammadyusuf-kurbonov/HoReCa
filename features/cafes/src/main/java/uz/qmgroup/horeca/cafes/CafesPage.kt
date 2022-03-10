package uz.qmgroup.horeca.cafes

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

@Composable
fun CafesPage(
    modifier: Modifier = Modifier,
    nextPage: () -> Unit
) {
    CafesTheme {
        Box(modifier = modifier) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "CAFES",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
                Image(
                    painter = painterResource(id = R.drawable.coffee_shop_amico),
                    contentDescription = "cafes"
                )
                Text(
                    text = "Find cafes with your taste",
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
                        text = "Compare cafes and search by both menu and price",
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
                    Text(text = "Finish")
                }
            }
        }
    }
}
