package uz.qmgroup.horeca.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.MainViewModel
import uz.qmgroup.horeca.home.HomeScreen
import uz.qmgroup.horeca.ui.theme.HoReCaTheme

@OptIn(ExperimentalMaterial3Api::class)
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

        NavigationDrawer(drawerContent = { AppDrawer() }, drawerState = viewModel.drawerState) {
            Column(modifier = modifier) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "HoReCa Uzbekistan",
                            style = MaterialTheme.typography.titleMedium,
                        )
                    },
                    actions = {
                        IconButton(onClick = {  }) {
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
                    },
                    colors = centerAlignedTopAppBarColors(
                        titleContentColor = MaterialTheme.colorScheme.tertiary,
                        navigationIconContentColor = MaterialTheme.colorScheme.primary,
                        actionIconContentColor = MaterialTheme.colorScheme.primary
                    )
                )

                HomeScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}