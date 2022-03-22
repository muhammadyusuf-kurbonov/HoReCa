package uz.qmgroup.horeca.hotels

import uz.qmgroup.horeca.common.BaseViewModel
import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.hotels.database.HotelsRepo

class HotelsViewModel: BaseViewModel<Hotel>() {
    override fun getRepo(): BaseRepository<Hotel> = HotelsRepo()
}