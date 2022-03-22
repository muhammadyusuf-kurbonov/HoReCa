package uz.qmgroup.horeca.cafes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import uz.qmgroup.horeca.common.components.ItemCard
import java.text.DateFormat
import java.util.*

fun formatWorkingTime(workingTime: Pair<Hour, Hour>): String {
    val format = DateFormat.getTimeInstance(DateFormat.SHORT)
    val startTime = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, workingTime.first.hour)
        set(Calendar.MINUTE, workingTime.first.minute)
    }
    val endTime = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, workingTime.second.hour)
        set(Calendar.MINUTE, workingTime.second.minute)
    }
    return format.format(startTime.time) + "\n" + format.format(endTime.time)
}

@Composable
fun CafeCard(
    modifier: Modifier = Modifier,
    cafe: Cafe,
    onClick: () -> Unit = {}
) {
    val image = cafe.imageUrl.ifEmpty { R.drawable.restaurant }

    ItemCard(
        image = rememberImagePainter(data = image) {
            transformations(RoundedCornersTransformation(16f))
        },
        title = cafe.title,
        subTitle = cafe.city,
        modifier = modifier.padding(8.dp),
        rating = cafe.rating,
        ratingStars = cafe.stars,
        onClick = onClick,
        additionalData = {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                horizontalAlignment = Alignment.End
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = cafe.address,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "",
                        modifier = Modifier.padding(4.dp),
                        tint = MaterialTheme.colors.primary
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${cafe.distanceToIt} km",
                        style = MaterialTheme.typography.body2,
                    )
                    Icon(
                        imageVector = Icons.Outlined.Explore,
                        contentDescription = "",
                        modifier = Modifier.padding(4.dp),
                        tint = MaterialTheme.colors.primary
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = formatWorkingTime(cafe.workTime),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = "",
                        modifier = Modifier.padding(4.dp),
                        tint = MaterialTheme.colors.primary
                    )
                }


                Text(text = cafe.comment, style = MaterialTheme.typography.body2)
            }
        }
    )
}