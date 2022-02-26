package uz.qmgroup.horeca.common

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.common.database.BaseRepository

abstract class BaseViewModel<E>: ViewModel() {
    val itemsList = mutableStateListOf<E>()

    protected abstract fun getRepo(): BaseRepository<E>

    fun loadPreviewData(){
        viewModelScope.launch {
            itemsList.clear()
            itemsList.addAll(getRepo().getAll().getFirst(4))
        }
    }
}