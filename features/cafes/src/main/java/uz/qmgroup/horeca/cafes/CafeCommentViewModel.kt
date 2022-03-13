package uz.qmgroup.horeca.cafes

import uz.qmgroup.horeca.common.comments.BaseCommentsViewModel
import uz.qmgroup.horeca.common.database.BaseRepository

class CafeCommentViewModel: BaseCommentsViewModel<Cafe>() {
    override fun getRepo(): BaseRepository<Cafe> = CafesRepo()
}