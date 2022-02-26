package uz.qmgroup.horeca.restaurants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SortDialog(
    modifier: Modifier = Modifier,
    applyFilter: (String) -> Unit,
) {
    Card {
        Surface(contentColor = Color(0xFFF05A22)) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            applyFilter("rating")
                        },
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(imageVector = Icons.Rounded.StarBorder, contentDescription = "")
                    Text(text = "Rating", style = MaterialTheme.typography.h6)
                }
                Divider(modifier = Modifier.fillMaxWidth(.6f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            applyFilter("distance")
                        },
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(imageVector = Icons.Outlined.Explore, contentDescription = "")
                    Text(text = "By distance", style = MaterialTheme.typography.h6)
                }
                Divider(modifier = Modifier.fillMaxWidth(.6f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            applyFilter("price")
                        },
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(imageVector = Icons.Rounded.CreditCard, contentDescription = "")
                    Text(text = "Price", style = MaterialTheme.typography.h6)
                }
            }
        }
    }
}