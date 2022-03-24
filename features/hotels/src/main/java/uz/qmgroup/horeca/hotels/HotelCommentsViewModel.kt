package uz.qmgroup.horeca.hotels

import uz.qmgroup.horeca.common.comments.BaseCommentsViewModel
import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.hotels.database.HotelsRepo

class HotelCommentsViewModel: BaseCommentsViewModel<Hotel>() {
    override fun getRepo(): BaseRepository<Hotel> = HotelsRepo()
}