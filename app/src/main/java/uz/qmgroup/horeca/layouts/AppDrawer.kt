package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.R

@Composable
private fun appMenu() = listOf(
    rememberVectorPainter(image = Icons.Outlined.Language) to "Tilni o'zgartirish",
    rememberVectorPainter(image = Icons.Outlined.AttachMoney) to "Valyutani o'zgartirish",
    rememberVectorPainter(image = Icons.Outlined.MyLocation) to "Geopozitsiya",
    rememberVectorPainter(image = Icons.Outlined.Hotel) to "Hotels",
    rememberVectorPainter(image = Icons.Outlined.Restaurant) to "Restaurants",
    rememberVectorPainter(image = Icons.Outlined.LocalCafe) to "Cafes",
)

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
) {
    Surface(contentColor = MaterialTheme.colors.primary) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = stringResource(
                    id = R.string.app_name
                ),
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .aspectRatio(1f)
            )

            val appMenu = appMenu()
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(4.dp)
            ) {
                items(appMenu) {
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

@Composable
fun AppDrawerItem(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    label: String
) {
    Card(
        modifier = modifier,
        elevation = 16.dp
    ){
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Icon(
                painter = iconPainter,
                contentDescription = label
            )
            Text(
                text = label,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}