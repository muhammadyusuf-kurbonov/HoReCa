package uz.qmgroup.horeca.common.comments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import uz.qmgroup.horeca.common.components.StarsComponent
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

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val item = viewModel.item ?: return@Column
        Text(text = item.title, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
        StarsComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp),
            rating = viewModel.rating,
            onClick = viewModel::updateRating
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.fullName,
            onValueChange = viewModel::updateFullName
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.phone,
            onValueChange = viewModel::updatePhone,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            )
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.comment,
            onValueChange = viewModel::updateComment,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            ),
            maxLines = 3
        )
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