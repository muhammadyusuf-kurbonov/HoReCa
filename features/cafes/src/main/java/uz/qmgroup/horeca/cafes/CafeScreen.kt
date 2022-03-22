package uz.qmgroup.horeca.cafes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsScreen

@Composable
fun CafesScreen(
    modifier: Modifier = Modifier,
    cafesViewModel: CafesViewModel = viewModel(),
    navigateToMain: () -> Unit,
    openDetails: (id: Long) -> Unit
) {
    CafesTheme {
        ItemsScreen(
            modifier = modifier,
            title = "Cafes",
            mainImage = painterResource(id = R.drawable.restaurant),
            viewModel = cafesViewModel,
            navigateBack = navigateToMain,
            dialog = {
                SortDialog(applyFilter = {})
            },
            renderItem = {
                CafeCard(
                    cafe = it,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {openDetails(it.id)}
                )
            }
        )
    }
}