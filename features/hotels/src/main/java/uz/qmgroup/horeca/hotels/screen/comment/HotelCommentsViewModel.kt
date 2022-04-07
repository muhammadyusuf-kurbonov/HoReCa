package uz.qmgroup.horeca.hotels.screen.comment

import uz.qmgroup.horeca.common.comments.BaseCommentsViewModel
import uz.qmgroup.horeca.common.database.BaseRepository
import uz.qmgroup.horeca.hotels.repository.Hotel
import uz.qmgroup.horeca.hotels.repository.HotelsRepo

class HotelCommentsViewModel: BaseCommentsViewModel<Hotel>() {
    override fun getRepo(): BaseRepository<Hotel> = HotelsRepo()
}