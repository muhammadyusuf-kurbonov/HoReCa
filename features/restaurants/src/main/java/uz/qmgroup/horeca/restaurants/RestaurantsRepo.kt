package uz.qmgroup.horeca.restaurants

import uz.qmgroup.horeca.common.database.BaseRepository

class RestaurantsRepo: BaseRepository<Restaurant> {
    override suspend fun getAll(): List<Restaurant> = listOf(
        Restaurant(
            title = "Hilton",
            city = "Tashkent",
            rating = 3.5f,
            stars = 2,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
            comment = "Hi. Best Restaurant",
            distanceToIt = 5L,
        ),
        Restaurant(
            title = "Big Hall",
            city = "Tashkent",
            rating = 3.5f,
            stars = 4,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        ),
        Restaurant(
            title = "Big Hall",
            city = "Tashkent",
            rating = 5f,
            stars = 3,
            address = "Farg'ona viloyati, Farg'ona shahri, A. Navoiy 32",
        )
    )

}