package uz.qmgroup.horeca.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.R
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@Composable
fun WelcomePage(
    modifier: Modifier = Modifier,
    nextPage: () -> Unit
) {
    HoReCaTheme {
        Box(modifier = modifier) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth()
                        .aspectRatio(1f),
                    painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                    contentDescription = "horeca"
                )
                Spacer(modifier = Modifier.height(64.dp))
                Button(
                    onClick = nextPage,
                    shape = RoundedCornerShape(99.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Start")
                }
            }
        }
    }
}