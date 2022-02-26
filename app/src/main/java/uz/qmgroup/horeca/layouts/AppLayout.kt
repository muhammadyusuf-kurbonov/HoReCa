package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
        var currentPage by remember {
            mutableStateOf("hotels")
        }

        Scaffold(
            modifier = modifier,
            scaffoldState = scaffoldState,
            topBar = {
                AppTopBar(openDrawer = { scope.launch { scaffoldState.drawerState.open() } })
            },
            bottomBar = {
                AppBottomBar(currentPage = currentPage, navigate = { currentPage = it })
            },
            drawerContent = { AppDrawer() },
        ) {
            HomeScreen(modifier = Modifier
                .fillMaxSize()
                .padding(it))
        }
    }
}