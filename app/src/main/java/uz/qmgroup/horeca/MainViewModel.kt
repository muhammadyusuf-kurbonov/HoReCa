package uz.qmgroup.horeca

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
class MainViewModel(
    val drawerState: DrawerState
) : ViewModel()