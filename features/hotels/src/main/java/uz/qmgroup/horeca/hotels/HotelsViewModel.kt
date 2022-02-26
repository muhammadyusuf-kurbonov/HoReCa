package uz.qmgroup.horeca.hotels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.qmgroup.horeca.common.getFirst
import uz.qmgroup.horeca.hotels.database.HotelsRepo

class HotelsViewModel: ViewModel() {
    private val repo = HotelsRepo()
    val hotelsList = mutableStateListOf<Hotel>()

    fun loadData(){
        viewModelScope.launch {
            hotelsList.clear()
            hotelsList.addAll(repo.getAllHotels().getFirst(4))
        }
    }
}