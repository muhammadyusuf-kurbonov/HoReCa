package uz.qmgroup.horeca.restaurants

import uz.qmgroup.horeca.common.comments.BaseCommentsViewModel
import uz.qmgroup.horeca.common.database.BaseRepository

class RestaurantCommentViewModel: BaseCommentsViewModel<Restaurant>() {
    override fun getRepo(): BaseRepository<Restaurant> = RestaurantsRepo()
}