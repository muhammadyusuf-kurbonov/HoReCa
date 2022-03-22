package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigateTo
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.NavGraphs
import uz.qmgroup.horeca.navDestination
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@Composable
fun AppLayout(
    modifier: Modifier = Modifier
) {
    HoReCaTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        val navHostController = rememberNavController()
        val backStackEntry by navHostController.currentBackStackEntryAsState()

        Scaffold(
            modifier = modifier,
            scaffoldState = scaffoldState,
            topBar = {
                AppTopBar(
                    openDrawer = { scope.launch { scaffoldState.drawerState.open() } }, navigateTo = {
                    navHostController.navigateTo(it)
                })
            },
            bottomBar = {
                AppBottomBar(currentPage = backStackEntry?.navDestination, navigate = {
                    if (backStackEntry?.navDestination != it) {
                        navHostController.navigateTo(it)
                    }
                })
            },
            drawerContent = { AppDrawer() },
        ) {
            DestinationsNavHost(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                navGraph = NavGraphs.root,
                navController = navHostController
            )
        }
    }
}