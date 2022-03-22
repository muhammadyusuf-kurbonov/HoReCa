package uz.qmgroup.horeca.common.comments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.components.ClickableStarsComponent
import uz.qmgroup.horeca.common.models.BaseObjectModel

@Composable
fun <E : BaseObjectModel> CommentsPage(
    modifier: Modifier = Modifier,
    id: Long,
    viewModel: BaseCommentsViewModel<E>,
    cancel: () -> Unit,
) {
    LaunchedEffect(key1 = id) {
        viewModel.loadItem(id)
    }

    val item = viewModel.item ?: return

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = item.title, style = MaterialTheme.typography.h3, fontWeight = FontWeight.Bold)
        ClickableStarsComponent(
            modifier = Modifier
                .padding(16.dp, 8.dp),
            rating = viewModel.rating,
            onClick = viewModel::updateRating
        )
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onBackground) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.fullName,
                onValueChange = viewModel::updateFullName,
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
                placeholder = { Text(text = "Full name") },
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.phone,
                onValueChange = viewModel::updatePhone,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                ),
                leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = "") },
                placeholder = { Text(text = "Phone") },
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.comment,
                onValueChange = viewModel::updateComment,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                ),
                maxLines = 3,
                leadingIcon = { Icon(imageVector = Icons.Default.Edit, contentDescription = "") },
                placeholder = { Text(text = "Comment") },
            )
        }
        Button(onClick = { viewModel.saveReview(id); cancel() }) {
            Text(text = "Submit")
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            TextButton(onClick = cancel) {
                Text(text = "Cancel")
            }
        }
    }
}