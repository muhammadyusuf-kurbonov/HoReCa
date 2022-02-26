package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.ui.screens.HomeScreen
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@Composable
fun AppLayout(
    modifier: Modifier = Modifier
) {
    HoReCaTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = modifier,
            scaffoldState = scaffoldState,
            topBar = {
                AppTopBar(openDrawer = { scope.launch { scaffoldState.drawerState.open() } })
            },
            bottomBar = {

            },
            drawerContent = { AppDrawer() },
        ) {
            HomeScreen(modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(0.dp, 8.dp))
        }
    }
}