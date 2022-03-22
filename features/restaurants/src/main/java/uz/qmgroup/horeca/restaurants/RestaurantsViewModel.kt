package uz.qmgroup.horeca.restaurants

import uz.qmgroup.horeca.common.BaseViewModel
import uz.qmgroup.horeca.common.database.BaseRepository

class RestaurantsViewModel: BaseViewModel<Restaurant>() {
    override fun getRepo(): BaseRepository<Restaurant> {
        return RestaurantsRepo()
    }
}