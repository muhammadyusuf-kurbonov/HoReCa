package uz.qmgroup.horeca.cafes

import uz.qmgroup.horeca.common.BaseViewModel
import uz.qmgroup.horeca.common.database.BaseRepository

class CafesViewModel: BaseViewModel<Cafe>() {
    override fun getRepo(): BaseRepository<Cafe> {
        return CafesRepo()
    }
}