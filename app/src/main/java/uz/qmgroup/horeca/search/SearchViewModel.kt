package uz.qmgroup.horeca.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    var searchPattern by mutableStateOf("")
        private set

    fun updateSearchPattern(newPattern: String){
        searchPattern = newPattern
    }
}