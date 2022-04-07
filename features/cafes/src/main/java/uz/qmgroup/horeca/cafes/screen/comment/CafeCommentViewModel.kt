package uz.qmgroup.horeca.cafes.screen.comment

import uz.qmgroup.horeca.cafes.CafesRepo
import uz.qmgroup.horeca.cafes.repository.Cafe
import uz.qmgroup.horeca.common.comments.BaseCommentsViewModel
import uz.qmgroup.horeca.common.database.BaseRepository

class CafeCommentViewModel: BaseCommentsViewModel<Cafe>() {
    override fun getRepo(): BaseRepository<Cafe> = CafesRepo()
}