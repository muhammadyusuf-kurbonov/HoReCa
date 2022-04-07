package uz.qmgroup.horeca.hotels

import uz.qmgroup.horeca.common.BaseViewModel
import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.hotels.repository.Hotel
import uz.qmgroup.horeca.hotels.repository.HotelsRepo

class HotelsViewModel: BaseViewModel<Hotel>() {
    override fun getRepo(): BaseRepository<Hotel> = HotelsRepo()
}