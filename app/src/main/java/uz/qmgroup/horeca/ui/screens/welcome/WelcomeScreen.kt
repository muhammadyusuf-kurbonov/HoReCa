package uz.qmgroup.horeca.ui.screens.welcome

import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import uz.qmgroup.horeca.cafes.CafesPage
import uz.qmgroup.horeca.hotels.HotelsPage
import uz.qmgroup.horeca.restaurants.RestaurantsPage
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    finishWizard: () -> Unit
) {
    var currentPage by remember { mutableStateOf(0) }
    HoReCaTheme {
        AnimatedContent(
            modifier = modifier,
            targetState = currentPage,
            transitionSpec = {
                if (targetState > initialState) {
                    // If the target number is larger, it slides up and fades in
                    // while the initial (smaller) number slides up and fades out.
                    slideInHorizontally { height -> height } + fadeIn() with
                            slideOutHorizontally { height -> -height } + fadeOut()
                } else {
                    // If the target number is smaller, it slides down and fades in
                    // while the initial number slides down and fades out.
                    slideInHorizontally { height -> -height } + fadeIn() with
                            slideOutHorizontally { height -> height } + fadeOut()
                }.using(
                    // Disable clipping since the faded slide-in/out should
                    // be displayed out of bounds.
                    SizeTransform(clip = false)
                )
            }
        ) {
            when (it) {
                0 -> WelcomePage(modifier = Modifier.fillMaxSize(), nextPage = { currentPage++ })
                1 -> HotelsPage(modifier = Modifier.fillMaxSize(), nextPage = { currentPage++ })
                2 -> RestaurantsPage(modifier = Modifier.fillMaxSize(), nextPage = { currentPage++ })
                3 -> CafesPage(modifier = Modifier.fillMaxSize(), nextPage = { currentPage++ })
                4 -> finishWizard()
            }
        }
    }
}