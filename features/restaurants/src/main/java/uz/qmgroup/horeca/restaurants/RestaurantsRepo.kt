package uz.qmgroup.horeca.restaurants

import uz.qmgroup.horeca.common.database.BaseRepository

class RestaurantsRepo: BaseRepository<Restaurant> {
    private val items = listOf(
        Restaurant(
            id = 0,
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            comment = "Hi. Best Restaurant",
            distanceToIt = 5L,
        ),
        Restaurant(
            id = 1,
            title = "Big Hall",
            city = "Tashkent",
            rating = 3.5f,
            stars = 4,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        ),
        Restaurant(
            id = 2,
            title = "Big Hall",
            city = "Tashkent",
            rating = 5f,
            stars = 3,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        )
    )

    override suspend fun get(id: Long): Restaurant = items[id.toInt()]

    override suspend fun getAll(): List<Restaurant> = items

    override suspend fun search(query: String): List<Restaurant> {
        return items.filter {
            it.title.contains(query) or it.address.contains(query)
        }
    }

}