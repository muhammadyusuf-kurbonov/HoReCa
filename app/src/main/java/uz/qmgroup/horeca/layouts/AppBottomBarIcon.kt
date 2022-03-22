package uz.qmgroup.horeca.layouts

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppBottomBarIcon(
    modifier: Modifier = Modifier,
    selected: Boolean,
    shortText: String,
    expandedText: String,
    color: Color
) {
    var text by remember { mutableStateOf("") }
    text = if (selected) expandedText else shortText
    AnimatedContent(targetState = text) { targetText ->
        Surface(color = color, shape = RoundedCornerShape(99.dp), modifier = Modifier
            .clip(RoundedCornerShape(99.dp))
            .then(modifier)
        ) {
            Text(
                text = targetText,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}