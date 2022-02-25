package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.MainViewModel
import uz.qmgroup.horeca.R
import uz.qmgroup.horeca.ui.screens.HomeScreen
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@Composable
fun AppLayout(
    modifier: Modifier = Modifier
) {
    HoReCaTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val viewModel = remember { MainViewModel(drawerState) }
        val scope = rememberCoroutineScope()

        fun openDrawer() {
            scope.launch { drawerState.open() }
        }

        ModalDrawer(drawerContent = { AppDrawer() }, drawerState = viewModel.drawerState) {
            Column(modifier = modifier) {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary,
                    title = {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                                contentDescription = "",
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth(.6f)
                                    .aspectRatio(1f)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { openDrawer() }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                            )
                        }
                    }
                )

                HomeScreen(modifier = Modifier.fillMaxSize().padding(0.dp, 8.dp))
            }
        }
    }
}