package uz.qmgroup.horeca.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.common.database.BaseRepository

abstract class BaseViewModel<E> : ViewModel() {
    val itemsList = mutableStateListOf<E>()
    var item by mutableStateOf<E?>(null)
        private set

    protected abstract fun getRepo(): BaseRepository<E>

    fun searchData(searchQuery: String){
        viewModelScope.launch {
            itemsList.clear()
            itemsList.addAll(
                getRepo().search(searchQuery)
            )
        }
    }

    fun loadData() {
        viewModelScope.launch {
            itemsList.clear()
            itemsList.addAll(getRepo().getAll())
        }
    }

    fun loadPreviewData() {
        viewModelScope.launch {
            itemsList.clear()
            itemsList.addAll(getRepo().getAll().getFirst(4))
        }
    }

    fun loadItem(id: Long) {
        viewModelScope.launch {
            item = null
            item = getRepo().get(id)
        }
    }
}