package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsGroup(
    modifier: Modifier = Modifier,
    optionsTextStyle: TextStyle = MaterialTheme.typography.body1,
    options: List<String>,
    icons: List<ImageVector> = emptyList(),
    onOptionClick: (String) -> Unit
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Max)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        options.forEachIndexed { index, option ->
            Button(
                shape = RoundedCornerShape(
                    topStart = if (index == 0) 99.dp else 0.dp,
                    bottomStart = if (index == 0) 99.dp else 0.dp,
                    topEnd = if (index == options.size - 1) 99.dp else 0.dp,
                    bottomEnd = if (index == options.size - 1) 99.dp else 0.dp,
                ),
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxHeight()
                    .weight(1f),
                onClick = { onOptionClick(option) },
                elevation = ButtonDefaults.elevation(4.dp)
            ) {
                Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    if (icons.isNotEmpty()) {
                        Icon(imageVector = icons[index], contentDescription = "")
                    }
                    Text(
                        text = option,
                        style = optionsTextStyle,
                        textAlign = TextAlign.Center,
                        maxLines = 2
                    )
                }
            }
        }
    }
}