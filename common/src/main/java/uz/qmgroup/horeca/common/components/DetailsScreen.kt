package uz.qmgroup.horeca.common.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Directions
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.models.Review
import uz.qmgroup.horeca.common.models.SocialPage
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    subTitle: String,
    stars: Int,
    price: Long,
    phone: String? = null,
    socialPages: List<Pair<SocialPage, String>> = emptyList(),
    features: @Composable (ColumnScope.() -> Unit),
    reviews: List<Review>,
    gotoBooking: () -> Unit,
) {
    LazyColumn(modifier = modifier) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
                contentDescription = ""
            )
        }
        item {
            Row(
                modifier = Modifier.padding(16.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onSurface
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                        Text(
                            text = subTitle,
                            style = MaterialTheme.typography.subtitle2,
                            color = MaterialTheme.colors.onSurface
                        )
                    }
                    StarsComponent(rating = stars)
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            MaterialTheme.typography.body2.toSpanStyle().copy(Color.Black)
                        ) {
                            append("from ")
                        }
                        withStyle(
                            MaterialTheme.typography.h6.toSpanStyle()
                                .copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colors.primary
                                )
                        ) {
                            append(NumberFormat.getCurrencyInstance().format(price))
                        }
                    })
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val context = LocalContext.current
                        if (phone != null && phone.isNotEmpty()) {
                            ContactButton(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(2.dp),
                                icon = Icons.Outlined.Phone
                            ) {
                                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel://$phone"))
                                context.startActivity(intent)
                            }
                        }
                        ContactButton(
                            modifier = Modifier
                                .weight(1f)
                                .padding(2.dp),
                            icon = Icons.Outlined.Email
                        ) {

                        }
                        ContactButton(
                            modifier = Modifier
                                .weight(1f)
                                .padding(2.dp),
                            icon = Icons.Outlined.Directions
                        ) {

                        }
                        ContactButton(
                            modifier = Modifier
                                .weight(1f)
                                .padding(2.dp),
                            icon = Icons.Outlined.Share
                        ) {

                        }
                    }
                }
            }
        }
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                features()
            }
        }
        item {
            Surface(contentColor = MaterialTheme.colors.onBackground) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "About cafe",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc rhoncus gravida nisl, sit amet ultrices mauris sagittis facilisis. Integer molestie arcu non orci gravida elementum. Aliquam nec ultricies felis. Donec tempor nisi ex, vel fringilla purus iaculis ac. Sed sagittis tortor a lectus accumsan, in aliquam dolor commodo. Sed aliquam luctus hendrerit. Fusce tincidunt nisl risus, eu lobortis tortor commodo non. Proin mattis aliquet dui, id blandit libero consequat sit amet. Proin a leo auctor, ultricies leo a, cursus ligula. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec semper laoreet orci ac pellentesque. Interdum et malesuada fames ac ante ipsum primis in faucibus.",
                        style = MaterialTheme.typography.body1,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 6
                    )
                }
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Divider(thickness = 2.dp, color = MaterialTheme.colors.primary)
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val context = LocalContext.current
                    socialPages.forEach {
                        IconButton(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                context.startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(it.second)
                                    )
                                )
                            }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                imageVector = it.first.icon, contentDescription = ""
                            )
                        }
                    }
                }
                Divider(thickness = 2.dp, color = MaterialTheme.colors.primary)
            }
        }
        item {
            Text(
                text = "Comments",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(
                    16.dp, 4.dp
                ),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
        }

        if (reviews.isNotEmpty()) {
            items(reviews) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 4.dp),
                    elevation = 16.dp
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = it.authorName,
                                style = MaterialTheme.typography.caption,
                                fontWeight = FontWeight.Bold
                            )

                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                                Text(
                                    text = DateFormat.getDateInstance().format(Date(it.date)),
                                    style = MaterialTheme.typography.caption,
                                )
                            }
                        }
                        Text(
                            text = it.comment,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        } else {
            item {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = "No comments yet",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = gotoBooking,
                    modifier = Modifier
                        .fillMaxWidth(.6f)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(99.dp)
                ) {
                    Text(text = "Start booking")
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}