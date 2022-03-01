package uz.qmgroup.horeca.hotels.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import uz.qmgroup.horeca.common.components.ItemsScreen
import uz.qmgroup.horeca.features.hotels.R
import uz.qmgroup.horeca.hotels.HotelsTheme
import uz.qmgroup.horeca.hotels.HotelsViewModel
import uz.qmgroup.horeca.hotels.SortDialog
import uz.qmgroup.horeca.hotels.components.HotelCard

@Composable
fun HotelsScreen(
    modifier: Modifier = Modifier,
    hotelsViewModel: HotelsViewModel = viewModel(),
    navigateToMain: () -> Unit,
    openDetails: (id: Long) -> Unit
) {
    HotelsTheme {
        ItemsScreen(
            modifier = modifier,
            title = "Hotels",
            mainImage = painterResource(id = R.mipmap.img_hilton),
            viewModel = hotelsViewModel,
            navigateBack = navigateToMain,
            dialog = {
                SortDialog(applyFilter = {})
            },
            renderItem = {
                HotelCard(
                    hotel = it,
                    modifier = Modifier.fillMaxWidth(),
                    onCLick = {openDetails(it.id)}
                )
            }
        )
    }
}