package uz.qmgroup.horeca.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsGroup(
    modifier: Modifier = Modifier,
    optionsTextStyle: TextStyle = MaterialTheme.typography.body1,
    options: List<String>,
    onOptionClick: (String) -> Unit
) {
    Row(
        modifier = modifier.height(IntrinsicSize.Max)
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
                modifier = Modifier.padding(0.dp)
                    .fillMaxHeight()
                    .weight(1f),
                onClick = { onOptionClick(option) },
                elevation = ButtonDefaults.elevation(4.dp)
            ) {
                Text(
                    text = option,
                    style = optionsTextStyle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp),
                    maxLines = 2
                )
            }
        }
    }
}